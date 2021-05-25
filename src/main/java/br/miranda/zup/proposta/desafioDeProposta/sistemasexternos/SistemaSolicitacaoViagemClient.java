package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.novaviagem.NovaViagemRequester;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888",name = "viagem")
@Component
public interface SistemaSolicitacaoViagemClient {

    @PostMapping("/api/cartoes/{numeroDoCartao}/avisos")
    ResponseEntity solicitarViagem(@PathVariable("numeroDoCartao") String numeroDoCartao, @RequestBody NovaViagemRequester requester);
}
