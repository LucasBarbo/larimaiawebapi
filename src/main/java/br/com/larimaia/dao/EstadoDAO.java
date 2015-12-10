package br.com.larimaia.dao;

import br.com.larimaia.entity.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EstadoDAO {
    private static EntityManager em;

    public EstadoDAO(){em = JPAUtil.abreConexao();}

    public void salvar(Estado estado) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(estado);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void excluir(Estado estado) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(estado);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }


    public List<Estado> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Estado c ORDER BY c.id");
        return consulta.getResultList();
    }

    public Estado buscarPorId(Integer id) {

        return em.find(Estado.class, id);
    }



}
