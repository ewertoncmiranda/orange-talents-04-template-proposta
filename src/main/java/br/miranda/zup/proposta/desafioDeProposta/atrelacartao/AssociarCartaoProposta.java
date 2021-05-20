package br.miranda.zup.proposta.desafioDeProposta.atrelacartao;


import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoResponse;
import br.miranda.zup.proposta.desafioDeProposta.enumeration.StatusProposta;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.PropostaRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SolicitaCartaoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AssociarCartaoProposta {
    private final Logger logger = LoggerFactory.getLogger(AssociarCartaoProposta.class);
    @Autowired
    SolicitaCartaoClient solicitaCartaoClient;

    @Autowired
    PropostaRepositorio propostaRepositorio;

    @Autowired
    CartaoRepositorio cartaoRepositorio;


    @Scheduled(fixedDelay = 15000)
    @Transactional
    public void analiseEAdiçãoDeCartaoAProposta(){

        for (Optional<Proposta> optional : propostaRepositorio.buscarPropostas()) {
            if(optional.isPresent()){
                Proposta proposta = optional.get() ;
                    if( proposta.getStatusProposta() == StatusProposta.ELEGIVEL){
                        CartaoResponse cartaoResponse = solicitaCartaoClient.solicita(new NovoCartaoRequester(proposta));

                        proposta.setCartao(cartaoRepositorio.save(cartaoResponse.toCartao(proposta)));

                        propostaRepositorio.save(proposta);
                        logger.warn("Cartão associado a proposta com sucesso.");
                    };
            };
        }

    }

}
