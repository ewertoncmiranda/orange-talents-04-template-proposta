package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/proposta")
@RestController
public class PropostaController {

    @Autowired
    PropostaRepositorio repositorio ;

    @PostMapping
    public ResponseEntity<?> criarNovaProposta(@RequestBody @Valid NovaPropostaRequester propostaRequester, UriComponentsBuilder uri) {
        Proposta proposta = propostaRequester.toModel();

        URI returnUri = uri.path("/proposta/{id}").build(repositorio.save(proposta).getId());
        return ResponseEntity.created(returnUri).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> criarNovaProposta(@PathVariable  Long id) {
      return  ResponseEntity.ok(repositorio.findById(id));
    }
}
