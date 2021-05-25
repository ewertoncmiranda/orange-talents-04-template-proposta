package br.miranda.zup.proposta.desafioDeProposta.bloqueio;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Bloqueio {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @CreationTimestamp
    private LocalDateTime bloqueadoEm ;
    @NotBlank
    private String ipOrigemBloqueio;
    @NotBlank
    private String agentUser ;

    @OneToOne(mappedBy = "bloqueio", fetch = FetchType.LAZY, orphanRemoval = false)
    private Cartao cartao;
    public Bloqueio(){}

    public Long getId() {return id;}
    public LocalDateTime getBloqueadoEm() {return bloqueadoEm;  }
    public String getIpOrigemBloqueio() { return ipOrigemBloqueio;  }
    public String getAgentUser() { return agentUser;  }


    public Bloqueio(String ipOrigemBloqueio, String agentUser) {
        this.ipOrigemBloqueio = ipOrigemBloqueio;
        this.agentUser = agentUser;    }
}
