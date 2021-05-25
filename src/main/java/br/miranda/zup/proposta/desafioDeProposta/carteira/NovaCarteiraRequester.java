package br.miranda.zup.proposta.desafioDeProposta.carteira;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.validacao.CarteirasPermitidas;
import br.miranda.zup.proposta.desafioDeProposta.validacao.EmailUnico;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaCarteiraRequester {

    public NovaCarteiraRequester(){}

    public NovaCarteiraRequester(@Email @EmailUnico String email,
                                 @CarteirasPermitidas @NotBlank TipoCarteira carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    @NotBlank @Email @EmailUnico
    String email ;


    @Enumerated(EnumType.STRING)
    @CarteirasPermitidas
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
