    package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.atrelacartao.NovoCartaoRequester;
import br.miranda.zup.proposta.desafioDeProposta.bloqueio.BloqueioRequester;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888" ,name = "cartao")
@Component
public interface SistemaExternoDeCartaoClient {

   @PostMapping("/api/cartoes")
   CartaoResponse solicitaCartaoParaAnalise(@RequestBody NovoCartaoRequester novoCartao);

   @PostMapping(value = "/api/cartoes/{id}/bloqueios",consumes = "application/json")
   ResponseEntity solicitaBloqueioParaOcartao
           (@PathVariable String id,
            @RequestBody BloqueioRequester bloqueioRequest) ;

}
