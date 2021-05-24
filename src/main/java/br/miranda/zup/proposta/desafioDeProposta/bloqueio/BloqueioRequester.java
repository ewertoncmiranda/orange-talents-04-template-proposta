package br.miranda.zup.proposta.desafioDeProposta.bloqueio;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.StatusCartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BloqueioRequester {

    @NotNull
    private String sistemaResponsavel;

    public BloqueioRequester() { }
    
    public BloqueioRequester(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {return sistemaResponsavel; }


    public Bloqueio toModel(String ipUsuario , String agentUser ){
      return new Bloqueio(ipUsuario,agentUser);
    }

}
