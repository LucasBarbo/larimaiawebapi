package br.com.larimaia.rest;

import br.com.larimaia.bo.PedidoBO;
import br.com.larimaia.entity.Pedido;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas on 25/09/2015.
 */

@Path("/pedido")
public class PedidoResources {
    @Inject
    PedidoBO pedidoBO;

    @Path("/salvar")
    @Consumes("application/json")
    public void salvar(Pedido pedido){pedidoBO.salvar(pedido);}

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(pedidoBO.editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){pedidoBO.remover(id); }
}
