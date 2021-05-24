package br.miranda.zup.proposta.desafioDeProposta.viagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    private String destinoViagem;

    private LocalDate dataTermino;

    @CreationTimestamp
    private LocalDateTime instante ;

    @ManyToOne(cascade = { CascadeType.ALL })
    private Cartao cartao;

    private String ipCliente;
    private String agenteDoUsuario;


    @Deprecated
    public Viagem() {}

    public Viagem(String destinoViagem, LocalDate dataTermino,String ipCliente, String agenteDoUsuario, Cartao cartao) {
        this.destinoViagem = destinoViagem;
        this.dataTermino = dataTermino;
        this.ipCliente = ipCliente;
        this.agenteDoUsuario = agenteDoUsuario;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public LocalDateTime getInstante() {   return instante;   }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getAgenteDoUsuario() {
        return agenteDoUsuario;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
