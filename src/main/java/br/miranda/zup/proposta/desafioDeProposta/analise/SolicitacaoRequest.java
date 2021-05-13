package br.miranda.zup.proposta.desafioDeProposta.analise;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;

public class SolicitacaoRequest {

    public SolicitacaoRequest() {
    }

    private String documento ;
    private String nome ;
    private String idProposta;

    public SolicitacaoRequest(Proposta requester){
       this.documento = requester.getDocumento();
       this.nome = requester.getNome();
       this.idProposta = requester.getId().toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
