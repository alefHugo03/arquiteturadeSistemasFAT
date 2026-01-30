package com.deliverytech.delivery_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;

import jakarta.transaction.Transactional;




@Service
@Transactional
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    
    public Cliente cadastrar(Cliente cliente){
        if( repository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("E-mail já Cadastrado");
        }
        cliente.setAtivo(true);
        cliente.setDataCadastro(LocalDateTime.now());
        return repository.save(cliente);
    }

    public List<Cliente> listarAtivos(){
        return repository.findByAtivoTrue();
    }

    public List<Cliente> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Cliente buscarPorId(@NonNull Long id){
        return repository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }

    public Cliente atualizar(@NonNull Long id, Cliente dadosAtualizados){
        Cliente cliente = buscarPorId(id);

        if (!cliente.getEmail().equals(dadosAtualizados.getEmail()) && repository.existsByEmail(dadosAtualizados.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado por outro cliente.");
        }

        cliente.setNome(dadosAtualizados.getNome());
        cliente.setEmail(dadosAtualizados.getEmail());
        cliente.setTelefone(dadosAtualizados.getTelefone());
        cliente.setEndereco(dadosAtualizados.getEndereco());
        return repository.save(cliente);
    }

    public void desativar(@NonNull Long id){
        Cliente fulano = buscarPorId(id);
        fulano.setAtivo(false);
        repository.save(fulano);
    }

    public void ativar(@NonNull Long id){
        Cliente fulano = buscarPorId(id);
        fulano.setAtivo(true);
        repository.save(fulano);
    }
    
}
