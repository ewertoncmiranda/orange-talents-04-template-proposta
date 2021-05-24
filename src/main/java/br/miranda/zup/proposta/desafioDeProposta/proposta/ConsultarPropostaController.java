package br.miranda.zup.proposta.desafioDeProposta.proposta;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import br.miranda.zup.proposta.desafioDeProposta.proposta.PropostaRepositorio;
import br.miranda.zup.proposta.desafioDeProposta.proposta.PropostaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/proposta")
public class ConsultarPropostaController {

    @Autowired
    PropostaRepositorio repositorio;



}
