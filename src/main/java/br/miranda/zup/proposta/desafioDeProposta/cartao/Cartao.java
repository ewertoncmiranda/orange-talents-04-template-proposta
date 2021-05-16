package br.miranda.zup.proposta.desafioDeProposta.cartao;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        this.numeroDoCartao = criptografaCartao(id);
        this.titular = titular;
        this.limite = new BigDecimal(limite);
        this.proposta = proposta;
    }

    private String criptografaCartao( String numeroDoCartao){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(numeroDoCartao.getBytes(),0,numeroDoCartao.length());
            byte[] digest =  messageDigest.digest();
            numeroDoCartao = new BigInteger(1,digest).toString(16);
            return numeroDoCartao;
        }catch (NoSuchAlgorithmException e){
           e.printStackTrace();
        }
        return "ERRO NA CRIPTOGRAFIA DO CARTAO" ;
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
