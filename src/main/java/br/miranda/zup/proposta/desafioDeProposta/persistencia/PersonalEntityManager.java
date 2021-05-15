package br.miranda.zup.proposta.desafioDeProposta.persistencia;


import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PersonalEntityManager{

    public PersonalEntityManager (){};

    @PersistenceContext
    EntityManager em ;

    public <E> E salvar(E objeto){
    em.persist(objeto);
    return objeto;
    }


    public Object encontrarPorId(Class<?> classe , Long id){
       Object object = em.find(classe,id);
       return object;
    }


}
