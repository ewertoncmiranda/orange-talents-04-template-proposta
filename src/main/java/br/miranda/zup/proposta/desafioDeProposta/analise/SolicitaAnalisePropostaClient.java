package br.miranda.zup.proposta.desafioDeProposta.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999" ,name = "solicitacao")
@Component
public interface SolicitaAnalisePropostaClient {

    @PostMapping("/api/solicitacao")
    public SolicitacaoAnaliseReponse busca(@RequestBody SolicitacaoAnaliseRequest request) ;

}
