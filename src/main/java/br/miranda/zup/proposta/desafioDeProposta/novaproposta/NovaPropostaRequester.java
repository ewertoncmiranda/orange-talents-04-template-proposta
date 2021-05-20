package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.validacao.DocumentoUnicoPorProposta;
import br.miranda.zup.proposta.desafioDeProposta.validacao.ValidaCpfOuCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaRequester {

    public NovaPropostaRequester() {
    }

    public NovaPropostaRequester(@NotBlank @ValidaCpfOuCnpj String documento,
                                 @NotBlank @Email String email,
                                 @NotBlank String endereco,
                                 @Positive @NotBlank BigDecimal salario,
                                 @NotBlank String nome ) {
        this.documento = documento;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
        this.nome = nome ;
    }

    private @ValidaCpfOuCnpj @DocumentoUnicoPorProposta
    @NotBlank String documento ;

    private @Email @NotBlank String email ;

    private @NotBlank String endereco ;

    private @Positive BigDecimal salario;

    private @NotBlank String nome ;

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {return nome;   }


    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "NovaPropostaRequester{" +
                "documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Proposta toModel() {
      return new Proposta(documento ,email,endereco,salario,nome);
    }
}
