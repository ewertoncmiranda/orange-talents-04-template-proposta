package br.miranda.zup.proposta.desafioDeProposta.carteira;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.sistemasexternos.SistemaCriacaoDeCarteira;
import br.miranda.zup.proposta.desafioDeProposta.tarefas.AdicionarCartaoACarteira;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/carteira")
@RestController
public class CarteiraController {

    private final Logger logger = LoggerFactory.getLogger(CarteiraController.class);

    @Autowired
    private CartaoRepositorio cartaoRepositorio;

    @Autowired
    private CarteiraRepositorio carteiraRepositorio;

    @Autowired
    AdicionarCartaoACarteira adicionarCartaoACarteira;

    @PostMapping("/{idCartao}")
    public ResponseEntity criarNovaCarteira(@PathVariable ("idCartao") Long idCartao,
                                            UriComponentsBuilder uriComponentsBuilder,
                                            @RequestBody @Valid NovaCarteiraRequester novaCarteira){

        Optional<Cartao> optCartao = cartaoRepositorio.findById(idCartao);
        if(optCartao.isPresent()){
            ResponseEntity<Carteira> response = adicionarCartaoACarteira.adicionaCartao(novaCarteira,optCartao.get());

                if (response.getStatusCode() == HttpStatus.OK){
                    Carteira carteira = response.getBody();
                    logger.info("Carteira criada com sucesso!");
                    carteira = carteiraRepositorio.save(carteira);
                    return  ResponseEntity.created(uriComponentsBuilder.path("/carteira/{id}").buildAndExpand(carteira.getId()).toUri()).build();
                }else if(response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY){
                    return  ResponseEntity.unprocessableEntity().body("Cartão já associado a carteira!");
                }
        }else{
            logger.info("Cartão não encontrado.");
            return ResponseEntity.notFound().build();
        }
        logger.info("Algo sinistro ocorreu e passou batido do if /else.");
        return  ResponseEntity.badRequest().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity consultarCarteira(@PathVariable Long id){
        Optional<Carteira> optCarteira = carteiraRepositorio.findById(id) ;
        if(optCarteira.isPresent()){
            return  ResponseEntity.ok().body(optCarteira.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}





