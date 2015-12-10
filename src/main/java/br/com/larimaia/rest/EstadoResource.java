package br.com.larimaia.rest;

import br.com.larimaia.bo.EstadoBO;
import br.com.larimaia.entity.Estado;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Usuario on 07/12/2015.
 */
@Path("/estado")
public class EstadoResource {

    @Inject
    EstadoBO estadoBO;

    private int id;


    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Estado estado) {
        estadoBO.salvar(estado);
        return Response.status(200).entity(estado).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id) {
        return Response.status(200).entity(estadoBO.editar(id)).build();
    }

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(estadoBO.listar()).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id) {
        estadoBO.excluir(estadoBO.editar(id));
    }

}
