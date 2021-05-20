package br.miranda.zup.proposta.desafioDeProposta.bloqueio;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.StatusCartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BloqueioRequester {

    @NotBlank
    private String enderecoIp ;
    @NotBlank
    private String agentUser ;
    @NotNull
    private Cartao cartao ;

    public  BloqueioRequester(){};

    public BloqueioRequester(  @NotBlank String enderecoIp ,
                               @NotBlank String agentUser ,
                               @NotNull Cartao cartao){
        cartao.setStatusCartao(StatusCartao.BLOQUEADO);
        this.cartao = cartao;
        this.enderecoIp =enderecoIp;
        this.agentUser = agentUser;
    }

    public Bloqueio toModel(){
        return  new Bloqueio(enderecoIp ,agentUser,cartao);
    }

    public String getEnderecoIp() {
        return enderecoIp;
    }

    public String getAgentUser() {
        return agentUser;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
