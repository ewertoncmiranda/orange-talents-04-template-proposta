package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseReponse;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999" ,name = "solicitacao")
@Component
public interface
SistemaAnalisePropostaClient {

    @PostMapping("/api/solicitacao")
    SolicitacaoAnaliseReponse busca(@RequestBody SolicitacaoAnaliseRequest request) ;

}
