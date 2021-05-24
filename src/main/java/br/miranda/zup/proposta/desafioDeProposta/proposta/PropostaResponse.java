package br.miranda.zup.proposta.desafioDeProposta.proposta;
import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;
public class PropostaResponse {

    private StatusProposta statusProposta;
    private String nome ;

    public PropostaResponse() {}
    public StatusProposta getStatusProposta() {
        return statusProposta;
    }

    public String getNome() {
        return nome;
    }

    public PropostaResponse ( Proposta proposta){
        this.statusProposta = proposta.getStatusProposta();
        this.nome = proposta.getNome();
    }
}
