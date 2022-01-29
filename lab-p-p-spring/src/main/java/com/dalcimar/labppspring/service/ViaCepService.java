package com.dalcimar.labppspring.service;

import com.dalcimar.labppspring.model.Endereco;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do <b>ViaCep</b>
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeig</a>
 * @see <a href="https://viacep.com.br">ViaCep</a>
 *
 * @author Dalcimar
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    
    @GetMapping( "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
