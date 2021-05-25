package br.miranda.zup.proposta.desafioDeProposta.carteira;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class NovaCarteiraRequester {

    @NotBlank
    private String email ;

    @Enumerated(EnumType.STRING)
    TipoCarteira carteira;

    public Carteira toModel(Cartao cartao ) {
       return new Carteira(cartao,email,carteira );
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return carteira;
    }
}
