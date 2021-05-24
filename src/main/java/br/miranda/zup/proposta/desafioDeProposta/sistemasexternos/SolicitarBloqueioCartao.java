package br.miranda.zup.proposta.desafioDeProposta.sistemasexternos;

import br.miranda.zup.proposta.desafioDeProposta.bloqueio.Bloqueio;
import br.miranda.zup.proposta.desafioDeProposta.bloqueio.BloqueioRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.bloqueio.BloqueioRequester;
import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.StatusCartao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SolicitarBloqueioCartao {

    public SolicitarBloqueioCartao(){};

    private final Logger logger = LoggerFactory.getLogger(SolicitarBloqueioCartao.class);

    @Autowired
    private SistemaExternoDeCartaoClient cartaoClient;

    @Autowired
    BloqueioRepositorio repositorio;

    public Cartao solicitarBloqueio( Cartao cartao, String ipUsuario , String agentUser){

        BloqueioRequester requester = new BloqueioRequester(agentUser);

        ResponseEntity response =
             cartaoClient.solicitaBloqueioParaOcartao(cartao.getId().toString() , requester);


       if(response.getStatusCode() == HttpStatus.OK){
           Bloqueio bloqueio = requester.toModel(ipUsuario,agentUser);
           cartao.setStatusCartao(StatusCartao.BLOQUEADO);
           cartao.setBloqueio(repositorio.save(bloqueio));
           logger.info("Cartao bloqueado com sucesso.");
           return cartao;
       } else{
           logger.info("Falha ao bloquear cartao.");
           return cartao;
       }
    }
}
