package br.com.zupacademy.mateus.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateus.casadocodigo.model.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado,Long> {

}
