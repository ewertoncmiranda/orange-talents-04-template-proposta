package br.miranda.zup.proposta.desafioDeProposta.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptographer {

    public Criptographer(){};

    public  String criptografaGeral(String docs){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(docs.getBytes(),0,docs.length());
            byte[] digest =  messageDigest.digest();
            docs = new BigInteger(1,digest).toString(16);
            return docs;
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "ERRO NA CRIPTOGRAFIA " ;
    }
}
