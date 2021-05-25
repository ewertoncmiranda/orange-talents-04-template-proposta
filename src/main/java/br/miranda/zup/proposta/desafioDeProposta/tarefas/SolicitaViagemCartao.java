package br.miranda.zup.proposta.desafioDeProposta.tarefas;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.novaviagem.NovaViagemRequester;
import br.miranda.zup.proposta.desafioDeProposta.novaviagem.Viagem;
import br.miranda.zup.proposta.desafioDeProposta.novaviagem.ViagemRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SistemaSolicitacaoViagemClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SolicitaViagemCartao {

    public SolicitaViagemCartao(){}

    private final Logger logger = LoggerFactory.getLogger(SolicitaViagemCartao.class);

    @Autowired
    private SistemaSolicitacaoViagemClient solicitacaoViagemClient;

    @Autowired
    private ViagemRepositorio viagemRepositorio;

    public Cartao solicitarViagem(Cartao cartao, NovaViagemRequester viagemRequester,String ipUsuario ,String agentUser){
        try {
            ResponseEntity response
                               = solicitacaoViagemClient.solicitarViagem(cartao.getNumeroDoCartao() ,viagemRequester);
             if(response.getStatusCode() == HttpStatus.OK){
                 Viagem viagem = viagemRequester.toModel(ipUsuario, agentUser,cartao);
                 viagem.setCartao(cartao);
                 viagemRepositorio.save(viagem);
                 logger.info("Solicitação de viagem autorizada para o cartão!");
                 return  cartao;
             }
        }catch (Exception e){
           logger.info("Catch - Erro ao solicitar viagem para o cartão.");
           return cartao;
        }
        return null;
    }

}
