package br.com.betereli;

import br.com.betereli.dao.DaoEndereco;
import br.com.betereli.dao.DaoPessoa;

import br.com.betereli.entities.Endereco;
import br.com.betereli.entities.Pessoa;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CrudTest {

    private DaoPessoa daoPessoa;
    private DaoEndereco daoEndereco;

    public CrudTest(){
        daoPessoa = new DaoPessoa();
        daoEndereco = new DaoEndereco();
    }


    @Test
    public void testeCadastrarPessoa(){

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Renan Betereli");
        pessoa.setSexo("M");
        pessoa.setIdade(33);
        pessoa = daoPessoa.cadastrar(pessoa);

        assertNotNull(pessoa);
        assertNotNull(pessoa.getId());

    }

    @Test
    public void testeCadastrarEndereco(){

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao");
        pessoa.setSexo("M");
        pessoa.setIdade(18);
        pessoa = daoPessoa.cadastrar(pessoa);

        assertNotNull(pessoa);
        assertNotNull(pessoa.getId());
        Endereco endereco = new Endereco();
        endereco.setCidade("Campinas");
        endereco.setEstado("SP");
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero(123);
        endereco.setPessoa(pessoa);

        endereco = daoEndereco.cadastrar(endereco);

        assertNotNull(endereco);
        assertNotNull(endereco.getId());

    }



    @Test
    public void testeRelacionamentoEntidades(){

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Luisa");
        pessoa1.setIdade(31);
        pessoa1.setSexo("F");
        pessoa1 = daoPessoa.cadastrar(pessoa1);


        Endereco endereco = new Endereco();
        endereco.setCidade("Valinhos");
        endereco.setEstado("SP");
        endereco.setLogradouro("Rua A");
        endereco.setNumero(852);
        endereco.setPessoa(pessoa1);

        endereco = daoEndereco.cadastrar(endereco);

        Endereco endereco1 = new Endereco();
        endereco1.setCidade("Bela Vista");
        endereco1.setEstado("MS");
        endereco1.setLogradouro("Rua B");
        endereco1.setNumero(963);
        endereco1.setPessoa(pessoa1);
        endereco1 = daoEndereco.cadastrar(endereco1);
        assertNotNull(endereco.getPessoa().getId());
        assertNotNull(endereco1.getPessoa().getId());



    }
    }



