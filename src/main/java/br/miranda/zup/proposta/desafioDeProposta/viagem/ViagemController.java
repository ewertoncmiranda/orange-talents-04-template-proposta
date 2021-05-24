package br.miranda.zup.proposta.desafioDeProposta.viagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoRepositorio;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cartao/viagem")
public class ViagemController {

    @Autowired
    CartaoRepositorio cartaoRepositorio;

    @Autowired
    ViagemRepositorio viagemRepositorio;

    @PostMapping("/{id}")
    public ResponseEntity avisoDeViagem(@PathVariable("id") Long id,
                                        @Valid @RequestBody NovaViagemRequester novaViagem ,
                                        @RequestHeader(value = "User-Agent") String userAgente,
                                        HttpServletRequest servletRequest){
        try {
            Optional<Cartao> optCartao = cartaoRepositorio.findById(id);
            if (optCartao.isPresent()){
                Viagem viagem = novaViagem.toModel(userAgente,servletRequest.getRemoteAddr(),optCartao.get());
                viagemRepositorio.save(viagem);
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
