package br.miranda.zup.proposta.desafioDeProposta.cartao;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CartaoResponse {

    public CartaoResponse(){}

    private String id ;
    private String emitidoEm ;
    private String titular ;
    private String limite ;

    public Cartao toCartao(Proposta proposta){
        return new Cartao(this.id ,this.emitidoEm ,this.titular ,this.limite ,proposta);
    }

    public String getId() {return id;}

    public String getEmitidoEm() {return emitidoEm; }

    public String getTitular() {return titular; }

    public String getLimite() {return limite; }

}
