package br.miranda.zup.proposta.desafioDeProposta.biometria;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String biometriaCarimbada;

    @CreationTimestamp
    private LocalDateTime associadaEm;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @Deprecated
    public Biometria(){}

    public Biometria(String biometriaCarimbada, Cartao cartao) {
        this.biometriaCarimbada = biometriaCarimbada;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }
}
