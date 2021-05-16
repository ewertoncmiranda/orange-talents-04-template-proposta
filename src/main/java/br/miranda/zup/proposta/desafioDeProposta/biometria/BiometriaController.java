package br.miranda.zup.proposta.desafioDeProposta.biometria;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    private final Logger log = LoggerFactory.getLogger(BiometriaController.class);

    @PersistenceContext
    EntityManager em ;

    @GetMapping("/cartao/{idCartao}")
    @Transactional
    public ResponseEntity cadastrarBiometria(@PathVariable Long idCartao , @RequestBody @Valid NovaBiometriaRequester requester, UriComponentsBuilder uriBuilder){
        Cartao cartao = em.find(Cartao.class , idCartao);

            if(cartao == null){
                log.warn("Cartao com  id "+idCartao+" não encontrado!");
                return ResponseEntity.notFound().build();
            }
        Biometria biometria = requester.toModel(cartao) ;

        em.persist(biometria);
        URI uri = uriBuilder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri();
        log.info("Biometra {} cadastrada!", biometria.getId());
        return ResponseEntity.created(uri).build();
    }


}
