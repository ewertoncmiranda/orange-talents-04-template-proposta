package br.miranda.zup.proposta.desafioDeProposta.tarefas;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.carteira.Carteira;
import br.miranda.zup.proposta.desafioDeProposta.carteira.CarteiraFeignResponse;
import br.miranda.zup.proposta.desafioDeProposta.carteira.NovaCarteiraRequester;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SistemaCriacaoDeCarteira;
import feign.FeignException;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class AdicionarCartaoACarteira {
    @Autowired
    private SistemaCriacaoDeCarteira criacaoDeCarteira;

    public ResponseEntity adicionaCartao(NovaCarteiraRequester novaCarteira , Cartao cartao){
    try {
        ResponseEntity<CarteiraFeignResponse> response = criacaoDeCarteira.associarCarteiraACartao(novaCarteira , cartao.getNumeroDoCartao());
        if(response.getStatusCode() == HttpStatus.OK){

            CarteiraFeignResponse carteiraFeignResponse = response.getBody();

            Carteira carteira = novaCarteira.toModel(cartao);
            carteira.setCodigoCarteira(carteiraFeignResponse.getId());
            carteira.setTipoCarteira(novaCarteira.getCarteira());
            carteira.setCartao(cartao);
            return ResponseEntity.ok().body(carteira);
        }else {
            return ResponseEntity.badRequest().build();
        }
     }catch (FeignException.UnprocessableEntity erro){
        return ResponseEntity.unprocessableEntity().build();
     }

    }
}
