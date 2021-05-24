package br.miranda.zup.proposta.desafioDeProposta.tarefas;

import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseReponse;
import br.miranda.zup.proposta.desafioDeProposta.analise.SolicitacaoAnaliseRequest;
import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SistemaAnalisePropostaClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnalisarProposta {

    private final Logger logger = LoggerFactory.getLogger(AnalisarProposta.class);

    public Proposta analisarProposta(Proposta proposta , SistemaAnalisePropostaClient analiseClient){
        try {
            SolicitacaoAnaliseRequest solicitacaoAnaliseRequest = new SolicitacaoAnaliseRequest(proposta);
            SolicitacaoAnaliseReponse resultadoDaConsulta = analiseClient.busca(solicitacaoAnaliseRequest);
            proposta.setStatusProposta(resultadoDaConsulta.getResultadoSolicitacao().getStatusProposta());
            logger.info("Documento da proposta ELEGIVEL");
            return proposta ;

        } catch (FeignException.UnprocessableEntity e){
            proposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
            logger.info("Documento da proposta NAO ELEGIVEL");
            return proposta;
        }
    }
}
