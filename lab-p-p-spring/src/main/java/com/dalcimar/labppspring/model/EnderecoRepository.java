package com.dalcimar.labppspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dalcimar
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
