package br.miranda.zup.proposta.desafioDeProposta.enumeration;

public enum StatusAnalise {
    COM_RESTRICAO(StatusProposta.NAO_ELEGIVEL) ,
    SEM_RESTRICAO(StatusProposta.ELEGIVEL) ;

    private final StatusProposta statusProposta;

    public StatusProposta getStatusProposta(){
        return statusProposta;
    }

    StatusAnalise(StatusProposta statusProposta){
        this.statusProposta = statusProposta;
    }
}
