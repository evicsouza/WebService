/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.evicsouza.webservice;

import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eva
 */

@Path("meuwebservice")
class MyApplicationController {
    
    @POST
    @Path("salvar") 
    public Response create(@QueryParam("generoDoLivro") String generoDoLivro, 
                           @QueryParam("nome") String nome){
        Livro livro = new Livro(generoDoLivro, nome);
        LivroDAO.getInstance().salvar(livro);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(livro)).build();
    }
   
    //localhost:8080/WebService/meuwebservice/listar
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarTodos(){
        Gson gson = new Gson();
        return gson.toJson(LivroDAO.getInstance().listarTodos());
    }
    //localhost:8080/WebService/meuwebservice/listarporid?id=2
    @GET
    @Path("listarporid")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarPorId(@QueryParam("id") int id){
        Livro livro = new Livro(id);
        Livro a = LivroDAO.getInstance().listarPorId(livro);
        Gson gson = new Gson();
        return gson.toJson(a);
    }
     //localhost:8080/WebService/meuwebservice/atualizar?id=2&tipodeanimal=cat&nome=gatinha  
    @PUT
    @Path("atualizar")
    public Response atualizar(@QueryParam("id") int id,
                           @QueryParam("generoDoLivro") String generoDoLivro, 
                           @QueryParam("nome") String nome){
        Livro a = new Livro(id, generoDoLivro, nome);
        a = LivroDAO.getInstance().atualizar(a);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(a)).build();    
    }
    //localhost:8080/WebService/meuwebservice/remover?id=1
    @DELETE
    @Path("remover")
    public String remover(@QueryParam("id") int id){
        Livro animal = new Livro(id);
        LivroDAO.getInstance().remover(animal);
        return listarTodos();
    }

    
}
