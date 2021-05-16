package br.miranda.zup.proposta.desafioDeProposta.biometria;

import br.miranda.zup.proposta.desafioDeProposta.cartao.Cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Base64;

public class NovaBiometriaRequester {

    public NovaBiometriaRequester() {
    }

    @NotNull
    private String carimboDoDedo;

    public String getCarimboDoDedo() {  return carimboDoDedo;   }

    public void setCarimboDoDedo(String carimboDoDedo) {
        this.carimboDoDedo = carimboDoDedo;
    }

    public Biometria toModel(Cartao cartao) {
        byte[] fingerPrintBase64 = Base64.getEncoder().encode(carimboDoDedo.getBytes());
        String biometriaConvertida = new String(fingerPrintBase64);
        return new Biometria(biometriaConvertida, cartao);
    }


}
