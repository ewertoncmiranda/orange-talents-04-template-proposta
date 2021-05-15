package br.miranda.zup.proposta.desafioDeProposta.atrelacartao;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;

public class NovoCartaoRequester {

    public NovoCartaoRequester(){}

    public NovoCartaoRequester(String documento, String nome, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public NovoCartaoRequester(Proposta proposta){
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }
    private String documento ;
    private String nome ;
    private Long idProposta;

    public String getDocumento() { return documento;   }
    public String getNome() {return nome; }
    public Long getIdProposta() {return idProposta;   }
}
