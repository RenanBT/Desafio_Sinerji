package br.com.betereli.dao;

import br.com.betereli.entities.Endereco;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DaoEndereco {
    public Endereco cadastrar(Endereco endereco) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(endereco);
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

        return endereco;
    }

    public Endereco buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Endereco endereco = null;

        try {
            endereco = entityManager.find(Endereco.class, id);
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

        return endereco;
    }

    public Endereco atualizar(Endereco endereco) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            endereco = entityManager.merge(endereco);
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

        return endereco;
    }

    public void deletar(Long id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("crud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Endereco endereco = entityManager.find(Endereco.class, id);
            if (endereco != null) {
                entityManager.remove(endereco);
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
