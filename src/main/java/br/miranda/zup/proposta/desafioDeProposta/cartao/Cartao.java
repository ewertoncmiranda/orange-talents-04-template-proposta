                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            package br.miranda.zup.proposta.desafioDeProposta.cartao;
import br.miranda.zup.proposta.desafioDeProposta.bloqueio.Bloqueio;
import br.miranda.zup.proposta.desafioDeProposta.carteira.Carteira;
import br.miranda.zup.proposta.desafioDeProposta.novaviagem.Viagem;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {

    public Cartao(){}

    private String emitidoEm ;
    private String numeroDoCartao ;
    private String titular ;
    private BigDecimal limite ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    @OneToOne(mappedBy = "cartao", fetch = FetchType.LAZY, orphanRemoval = false)
    private Proposta proposta ;

    @OneToOne
    @JoinColumn(name = "bloqueio_id")
    private Bloqueio bloqueio;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id")
    private final List<Viagem> viagem = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "cartao_id")
    List<Carteira> carteirasDisponiveis;

    @Enumerated(EnumType.STRING)
    public StatusCartao statusCartao = StatusCartao.ATIVO;

    public Cartao(String id, String emitidoEm, String titular,String limite ,Proposta proposta) {
        this.numeroDoCartao = id;
        this.titular = titular;
        this.limite = new BigDecimal(limite);
        this.proposta = proposta;
        this.emitidoEm = emitidoEm;
    }

    public boolean estaBloqueado(){
        return this.getStatusCartao() == StatusCartao.BLOQUEADO;
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

    public Proposta getProposta() {return proposta; }

    public Bloqueio getBloqueio() {return bloqueio;  }

    public StatusCartao getStatusCartao() {return statusCartao; }

    public String getNumeroDoCartao() {return numeroDoCartao;  }

    public BigDecimal getLimite() {return limite;  }

    public void setStatusCartao(StatusCartao statusCartao) {
        this.statusCartao = statusCartao;
    }

    public void setBloqueio(Bloqueio bloqueio) {
        this.bloqueio = bloqueio;
    }
}
