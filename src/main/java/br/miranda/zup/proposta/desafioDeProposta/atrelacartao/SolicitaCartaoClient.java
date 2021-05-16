    package br.miranda.zup.proposta.desafioDeProposta.atrelacartao;

import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888/" ,name = "cartao")
public interface SolicitaCartaoClient {

    @PostMapping("/api/cartoes")
   public CartaoResponse solicita(@RequestBody NovoCartaoRequester novoCartao);

}
