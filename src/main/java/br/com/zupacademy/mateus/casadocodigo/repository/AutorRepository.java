package br.com.zupacademy.mateus.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateus.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor,Long>{

}
