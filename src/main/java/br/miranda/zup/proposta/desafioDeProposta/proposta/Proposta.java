package br.miranda.zup.proposta.desafioDeProposta.proposta;

import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;
import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.validacao.ValidaCpfOuCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    public Proposta(){
    };

    public Proposta(@NotBlank @ValidaCpfOuCnpj String documento,
                    @NotBlank @Email String email,
                    @NotBlank String endereco,
                    @Positive @NotBlank BigDecimal salario,
                    @NotNull String nome) {
        this.documento = documento;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
        this.nome = nome ;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id ;

    private @ValidaCpfOuCnpj @NotBlank String documento ;

    private @Email @NotBlank String email ;

    private @NotBlank String endereco ;

    private @Positive BigDecimal salario;

   @OneToOne
   @JoinColumn(name = "cartao_id")
   private Cartao cartao;

    private @NotNull String nome ;

    public void setStatusProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }

    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {    return nome;    }

    public String getEndereco() {
        return endereco;
    }


    public BigDecimal getSalario() {
        return salario;
    }

    public Long getId() {
        return id;
    }

    public StatusProposta getStatusProposta() {
        return statusProposta;
    }

    public void setCartao(Cartao cartao) { this.cartao = cartao;   }

    @Override
    public String toString() {
        return "NovaPropostaRequester{" +
                "documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                '}';
    }
}
