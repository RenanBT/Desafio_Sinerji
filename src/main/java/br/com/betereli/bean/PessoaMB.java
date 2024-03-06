package br.com.betereli.bean;

import br.com.betereli.entities.Pessoa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PessoaMB {
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> listaPessoas = new ArrayList<>();
    // Métodos para operações CRUD
    public void cadastrar() {
        // Implementação para salvar uma nova pessoa no banco de dados
    }

    public void atualizar() {
        // Implementação para atualizar uma pessoa no banco de dados
    }

    public void deletar(Long id) {
        // Implementação para deletar uma pessoa do banco de dados
    }

    // Getters e setters
    // (Incluindo getters e setters para pessoa e listaPessoas)
}