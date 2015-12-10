package br.com.larimaia.bo;

import br.com.larimaia.dao.EstadoDAO;
import br.com.larimaia.entity.Estado;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Usuario on 07/12/2015.
 */
@Dependent
public class EstadoBO  {

    private EstadoDAO estadoDAO = new EstadoDAO();


    public EstadoBO(){}

    public void salvar(Estado estado) {
        try {
            estadoDAO.salvar(estado);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Estado> listar() {
        return estadoDAO.buscarTodos();
    }

    public void excluir(Estado estado) {
        estadoDAO.excluir(estado);
    }

    public Estado editar(int id) {
        return estadoDAO.buscarPorId(id);
    }


}
