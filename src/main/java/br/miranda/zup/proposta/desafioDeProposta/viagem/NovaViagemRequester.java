package br.miranda.zup.proposta.desafioDeProposta.viagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NovaViagemRequester {

    @Deprecated
    public NovaViagemRequester(){}

    @NotBlank
    private String destinoViagem ;

    @Future @NotNull @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataTerminoViagem ;

    public NovaViagemRequester(@NotNull String destinoViagem ,
                                @NotNull LocalDate dataTerminoViagem){
        this.dataTerminoViagem = dataTerminoViagem;
        this.destinoViagem = destinoViagem;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getDataTerminoViagem() {
        return dataTerminoViagem;
    }

    public Viagem toModel(String ipSolicitante,
                          String agentClient,
                          Cartao cartao){
      return new Viagem(this.destinoViagem,this.dataTerminoViagem ,ipSolicitante,agentClient,cartao);
    };
}
