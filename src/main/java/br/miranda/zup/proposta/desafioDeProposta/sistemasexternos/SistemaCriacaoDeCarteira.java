package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.carteira.CarteiraFeignResponse;
import br.miranda.zup.proposta.desafioDeProposta.carteira.NovaCarteiraRequester;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888/" ,name = "carteira")
@Component
public interface SistemaCriacaoDeCarteira {

    @PostMapping("/api/cartoes/{numeroCartao}/carteiras")
    public ResponseEntity<CarteiraFeignResponse> associarCarteiraACartao(@RequestBody NovaCarteiraRequester novaCarteira,
                                                                         @PathVariable String numeroCartao);

}
