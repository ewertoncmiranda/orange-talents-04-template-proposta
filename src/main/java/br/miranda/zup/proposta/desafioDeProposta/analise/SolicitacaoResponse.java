package br.miranda.zup.proposta.desafioDeProposta.analise;

import br.miranda.zup.proposta.desafioDeProposta.novaproposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.novaproposta.StatusProposta;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SolicitacaoResponse {

    public SolicitacaoResponse() {
    }
    private String documento ;
    private String nome ;
    private String idProposta;

    @Enumerated(EnumType.STRING)
    private StatusProposta resultadoSolicitacao ;

    public SolicitacaoResponse(String documento, String nome, String idProposta, StatusProposta resultadoSolicitacao) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public StatusProposta getResultadoSolicitacao() { return resultadoSolicitacao;  }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public Proposta toModel(EntityManager em) {
        Proposta proposta = em.find(Proposta.class , Long.parseLong(this.getIdProposta()));
        proposta.setStatusProposta(getResultadoSolicitacao());
        return proposta;
    }
}
