package com.dalcimar.labppspring.service.impl;

import com.dalcimar.labppspring.model.Cliente;
import com.dalcimar.labppspring.model.ClienteRepository;
import com.dalcimar.labppspring.model.Endereco;
import com.dalcimar.labppspring.model.EnderecoRepository;
import com.dalcimar.labppspring.service.ClienteService;
import com.dalcimar.labppspring.service.ViaCepService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author Dalcimar
 */

@Service
public class ClienteServiceImpl implements ClienteService {

    // TODO Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private ViaCepService viaCepService;
    // TODO Strategy: Implementar os métodos definidos na interface.
    // TODO Facade: Abstrair integraçoes com subsistemas, provendo uma interface simples.
    
    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME buscar todos os Clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // FIXME buscar Clientes por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        // FIXME Buscar Cliente por ID, caso exista.
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()) {
        // FIXME Verificar se o Endereço do Cliente já existe pelo "CEP".
        // FIXME Caso não exista, integrar com o ViaCep e persistir o retutno.
        // FIXME Alterar Cliente, vinculado o Endereço "novo ou existente"
            salvarClienteComCep(cliente);
        }
    }
    
    @Override
    public void deletar(Long id) {
        // FIXME Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }
    
    private void salvarClienteComCep(Cliente cliente) {
        // FIXME Verificar se o Endereço do Cliente já existe pelo "CEP".
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // FIXME Caso não exista, integrar com o ViaCep e persistir o retutno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // FIXME Inserir Cliente, vinculado o Endereço "novo ou existente".
        clienteRepository.save(cliente);
    }
   
}
