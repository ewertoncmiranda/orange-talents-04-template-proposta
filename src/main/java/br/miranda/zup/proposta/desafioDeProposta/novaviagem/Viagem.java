package br.miranda.zup.proposta.desafioDeProposta.novaviagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Viagem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    private Cartao cartao;

    private String destino ;

    private LocalDate validoAte;

    private String ipRequest ;

    private String agentUser;

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Viagem(String destino, LocalDate validoAte, String ipRequest, String agentUser, Cartao cartao) {
        this.destino = destino;
        this.validoAte = validoAte;
        this.ipRequest = ipRequest;
        this.agentUser = agentUser;
        this.cartao = cartao;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getIpRequest() {
        return ipRequest;
    }

    public String getAgentUser() {
        return agentUser;
    }

    @Deprecated
    public Viagem() {
    }
}
