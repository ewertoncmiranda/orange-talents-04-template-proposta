package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import br.miranda.zup.proposta.desafioDeProposta.validacao.ValidaCpfOuCnpj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    public Proposta(@NotBlank @ValidaCpfOuCnpj String documento,
                    @NotBlank @Email String email,
                    @NotBlank String endereco,
                    @Positive @NotBlank BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id ;

    private @ValidaCpfOuCnpj @NotBlank String documento ;

    private @Email @NotBlank String email ;

    private @NotBlank String endereco ;

    private @Positive BigDecimal salario;

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }
    public Long getId() {
        return id;
    }

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
