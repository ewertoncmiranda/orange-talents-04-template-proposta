package br.miranda.zup.proposta.desafioDeProposta.bloqueio;


import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/bloqueio")
public class BloqueioController {

    @Autowired
    CartaoRepositorio cartaoRepositorio;

    @Autowired
    BloqueioRepositorio bloqueioRepositorio;

    @PersistenceContext
    EntityManager entityManager ;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity solicitarBloqueio(@PathVariable Long id ,
                                            HttpServletRequest servletRequest,
                                            @RequestHeader(value = "User-Agent") String userAgent){
      Optional<Cartao> cartaoOptionl = cartaoRepositorio.findById(id) ;

          if(cartaoOptionl.isPresent()){
             Cartao cartao = cartaoOptionl.get();
                if(cartao.estaBloqueado()) {
                    return ResponseEntity.unprocessableEntity().body("CARTAO JÁ ESTÁ BLOQUEADO!");
                }else {
                    BloqueioRequester bloqueioRequester = new BloqueioRequester(servletRequest.getRemoteUser().toString() , userAgent , cartao);
                    Bloqueio bloqueio = bloqueioRequester.toModel();
                    cartao.setBloqueio(bloqueioRepositorio.save(bloqueio));
                    cartaoRepositorio.save(cartao);
                    return  ResponseEntity.ok("Cartao bloqueado com sucesso.");
                }
          }else { return  ResponseEntity.notFound().build();}
    }


}
