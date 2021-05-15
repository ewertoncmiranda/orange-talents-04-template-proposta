package br.miranda.zup.proposta.desafioDeProposta.cartao;

import br.miranda.zup.proposta.desafioDeProposta.persistencia.PersonalEntityManager;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Cartao {

    public Cartao(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id   ;

    @OneToOne(mappedBy = "cartao", fetch = FetchType.LAZY, orphanRemoval = false)
    private Proposta proposta ;

    private String numeroDoCartao ;
    private String emitidoEm ;
    private String titular ;
    private BigDecimal limite ;


    public Cartao(String id, String emitidoEm, String titular,String limite ,Proposta proposta) {
        this.numeroDoCartao = id;
        this.titular = titular;
        this.limite = new BigDecimal(limite);
        PersonalEntityManager pem =new PersonalEntityManager();
        this.proposta = proposta;

    }


    public Cartao(Long id, String emitidoEm, String titular) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }
}
