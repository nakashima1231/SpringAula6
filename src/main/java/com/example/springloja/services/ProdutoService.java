package com.example.springloja.services;

import com.example.springloja.dto.ProdutoDTO;
import com.example.springloja.entities.Produto;
import com.example.springloja.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .toList();
    }

    public void salvar(Produto produto) {
        repository.save(produto);
    }

    public void atualizar(Produto produto){
        repository.save(produto);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public List<ProdutoDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).stream().map(ProdutoDTO::new).toList();
    }

    public List<ProdutoDTO> buscarPorPrecoMaximo(Double preco) {
        return repository.findByPrecoLessThanEqual(preco).stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO buscarPorId(Long id){
        return repository.findById(id).stream().map(ProdutoDTO::new).findFirst().orElse(null);
    }
}
