package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitaAnaliseFeign;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoRequest;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/proposta")
@RestController
public class PropostaController {

    @Autowired
    private PropostaRepositorio repositorio ;

    @PersistenceContext
    private EntityManager em ;

    @Autowired
    private SolicitaAnaliseFeign analise ;

    @PostMapping
    public ResponseEntity<?> criarNovaProposta(@RequestBody @Valid NovaPropostaRequester propostaRequester /*, UriComponentsBuilder uri*/) {

        Proposta proposta = propostaRequester.toModel() ;

        proposta = repositorio.save(proposta) ;

        SolicitacaoRequest solicitacaoRequest = new SolicitacaoRequest(proposta);

        ResponseEntity responseEntity = analise.busca(solicitacaoRequest);

        SolicitacaoResponse solicitacaoResponse = (SolicitacaoResponse) responseEntity.getBody();

        repositorio.save(solicitacaoResponse.toModel(em));

        //URI returnUri = uri.path("/proposta/{id}").build(repositorio.save(proposta).getId());
        return ResponseEntity.ok().body(repositorio.save(solicitacaoResponse.toModel(em)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> criarNovaProposta(@PathVariable  Long id) {
      return  ResponseEntity.ok(repositorio.findById(id));
    }
}
