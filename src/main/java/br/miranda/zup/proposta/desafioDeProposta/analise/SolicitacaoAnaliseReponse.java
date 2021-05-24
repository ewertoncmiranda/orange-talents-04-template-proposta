package br.miranda.zup.proposta.desafioDeProposta.analise;

import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusAnalise;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SolicitacaoAnaliseReponse {

    public SolicitacaoAnaliseReponse() {
    }
    private String documento ;
    private String nome ;
    private String idProposta;

    @Enumerated(EnumType.STRING)
    private StatusAnalise resultadoSolicitacao ;

    public StatusAnalise getResultadoSolicitacao() { return resultadoSolicitacao;  }

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
        return proposta;
    }
}
