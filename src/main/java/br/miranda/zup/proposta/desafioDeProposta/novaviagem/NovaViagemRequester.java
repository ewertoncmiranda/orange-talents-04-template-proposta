package br.miranda.zup.proposta.desafioDeProposta.novaviagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NovaViagemRequester {

    @NotBlank
    private String destino ;

    @Future @JsonFormat(pattern = "yyyy-MM-dd" ,shape = JsonFormat.Shape.STRING)
    private LocalDate validoAte ;

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public NovaViagemRequester() {
    }

    public Viagem toModel(String ipRequest , String agentUser, Cartao cartao) {
        return  new Viagem(destino ,validoAte ,ipRequest,agentUser,cartao);
    }
}
