package br.com.zupacademy.mateus.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateus.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro,Long>{

}
