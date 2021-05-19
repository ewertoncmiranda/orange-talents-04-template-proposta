package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitaAnalisePropostaClient;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseRequest;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseReponse;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoResponse;
import br.miranda.zup.proposta.desafioDeProposta.atrelacartao.NovoCartaoRequester;
import br.miranda.zup.proposta.desafioDeProposta.atrelacartao.SolicitaCartaoClient;
import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.PropostaRepositorio;
import feign.FeignException.UnprocessableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
            return proposta ;

        } catch (UnprocessableEntity e){
            proposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
            return proposta;
        }
    }

    @GetMapping
     public String sayHello(){
     return  "Ola mundo!" ;
    };
}
