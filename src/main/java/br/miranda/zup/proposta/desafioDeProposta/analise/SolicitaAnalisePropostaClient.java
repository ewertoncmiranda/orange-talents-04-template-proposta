package br.miranda.zup.proposta.desafioDeProposta.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999" ,name = "solicitacao")
public interface SolicitaAnalisePropostaClient {

    @PostMapping("/api/solicitacao")
    public SolicitacaoAnaliseReponse busca(@RequestBody SolicitacaoAnaliseRequest request) ;


}
