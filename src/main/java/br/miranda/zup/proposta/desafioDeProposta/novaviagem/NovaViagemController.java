package br.miranda.zup.proposta.desafioDeProposta.novaviagem;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;
import br.miranda.zup.proposta.desafioDeProposta.cartao.CartaoRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.cartao.StatusCartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/viagem")
@RestController
public class NovaViagemController {

    @Autowired
    private CartaoRepositorio repositorioCartao;

    @Autowired
    private  ViagemRepositorio viagemRepositorio;

    @PostMapping("/{idCartao}")
    public ResponseEntity teste(@PathVariable("idCartao") Long idCartao,
                                HttpServletRequest request,
                                @RequestHeader ("User-Agent") String agentUser,
                                @RequestBody @Valid NovaViagemRequester novaViagem){
        try {
            Optional<Cartao> optCartao = repositorioCartao.findById(idCartao);
            if (optCartao.isPresent()){
                if (optCartao.get().getStatusCartao() == StatusCartao.BLOQUEADO) {
                  return ResponseEntity.unprocessableEntity().body("Cartoa Bloqueado! Não é possivel adicionar viagem.");
                }else {
                    Viagem viagem = novaViagem.toModel(request.getRemoteAddr(), agentUser, optCartao.get());
                    viagemRepositorio.save(viagem);
                    return ResponseEntity.ok().build();
                }
            }else {
                return  ResponseEntity.notFound().build();
            }
        }catch (Exception e){
         return  ResponseEntity.badRequest().build();
        }
    }

}
