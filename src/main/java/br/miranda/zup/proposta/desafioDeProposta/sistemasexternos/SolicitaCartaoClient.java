    package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.atrelacartao.NovoCartaoRequester;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888" ,name = "cartao")
@Component
public interface SolicitaCartaoClient {

    @PostMapping("/api/cartoes")
   public CartaoResponse solicita(@RequestBody NovoCartaoRequester novoCartao);

}
