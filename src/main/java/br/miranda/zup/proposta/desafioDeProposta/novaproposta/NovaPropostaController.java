package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import br.miranda.zup.proposta.desafioDeProposta.atrelacartao.AssociarCartaoProposta;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SolicitaAnalisePropostaClient;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseRequest;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseReponse;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SolicitaCartaoClient;
import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.PropostaRepositorio;
import feign.FeignException.UnprocessableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/proposta")
@RestController
public class NovaPropostaController {

    @Autowired
    private PropostaRepositorio repositorio ;

    @Autowired
    private SolicitaCartaoClient solicitaCartaoClient;

    @PersistenceContext
    private EntityManager em ;

    @Autowired
    private SolicitaAnalisePropostaClient analiseClient ;

    private final Logger logger = LoggerFactory.getLogger(NovaPropostaController.class);

    @PostMapping
    public ResponseEntity<?> criarNovaProposta(@RequestBody @Valid NovaPropostaRequester propostaRequester   , UriComponentsBuilder uri) {
        Proposta proposta = propostaRequester.toModel() ;
        repositorio.save(proposta) ;
        Proposta props = analisaProposta(proposta);
        Long id = repositorio.save(props).getId() ;

        URI returnUri = uri.path("/proposta/{id}").build(id);
        return ResponseEntity.created(returnUri).build();
    }

    public Proposta analisaProposta(Proposta proposta){
        try {
            SolicitacaoAnaliseRequest solicitacaoAnaliseRequest = new SolicitacaoAnaliseRequest(proposta);
            SolicitacaoAnaliseReponse resultadoDaConsulta = analiseClient.busca(solicitacaoAnaliseRequest);
            proposta.setStatusProposta(resultadoDaConsulta.getResultadoSolicitacao().getStatusProposta());
            logger.info("Documento da proposta ELEGIVEL");
            return proposta ;

        } catch (UnprocessableEntity e){
            proposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
            logger.info("Documento da proposta NAO ELEGIVEL");
            return proposta;
        }
    }

    @GetMapping
     public String sayHello(){
     return  "Ola mundo!" ;
    };
}
