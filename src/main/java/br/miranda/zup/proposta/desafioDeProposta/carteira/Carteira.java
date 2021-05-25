package br.miranda.zup.proposta.desafioDeProposta.carteira;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;

import javax.persistence.*;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoCarteira ;

    @ManyToOne
    private Cartao cartao;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCarteira tipoCarteira;

    @Deprecated
    public Carteira() {}

    public Carteira(Cartao cartao, String email, TipoCarteira carteira) {
        this.cartao = cartao;
        this.email = email;
        this.tipoCarteira = carteira;
    }

    public Carteira(Cartao cartao, TipoCarteira tipoCarteira) {
        this.cartao = cartao;
        this.tipoCarteira = tipoCarteira;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public void setTipoCarteira(TipoCarteira tipoCarteira) {
        this.tipoCarteira = tipoCarteira;
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return tipoCarteira;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public void setCodigoCarteira(String codigoCarteira) {
        this.codigoCarteira = codigoCarteira;
    }
}
