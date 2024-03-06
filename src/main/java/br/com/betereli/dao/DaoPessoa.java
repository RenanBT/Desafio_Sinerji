package br.com.betereli.dao;

import br.com.betereli.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DaoPessoa {
    public Pessoa cadastrar(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Ou faça um log da exceção
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

        return pessoa;
    }

    public Pessoa buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pessoa pessoa = null;

        try {
            pessoa = entityManager.find(Pessoa.class, id);
        } catch (Exception e) {
            e.printStackTrace(); // Ou faça um log da exceção
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            pessoa = entityManager.merge(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Ou faça um log da exceção
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

        return pessoa;
    }

    public void deletar(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Pessoa pessoa = entityManager.find(Pessoa.class, id);
            if (pessoa != null) {
                entityManager.remove(pessoa);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Ou faça um log da exceção
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }




}

