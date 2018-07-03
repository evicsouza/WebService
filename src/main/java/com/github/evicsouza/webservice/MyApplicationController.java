/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.evicsouza.webservice;

import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    
    @GET
    @Path("salvar") 
    public Response create(@QueryParam("generoDoLivro") String generoDoLivro, 
                           @QueryParam("nome") String nome){
        Livro animal = new Livro(generoDoLivro,nome);
        LivrolDAO.getInstance().salvar(animal);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(animal)).build();
    }
   
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarTodos(){
        Gson gson = new Gson();
        return gson.toJson(LivrolDAO.getInstance().listarTodos());
    }
    
    @GET
    @Path("listarporid")
    @Produces(MediaType.TEXT_PLAIN)
    public String listarPorId(@QueryParam("id") int id){
        Livro animal = new Livro(id);
        Livro a = LivrolDAO.getInstance().listarPorId(animal);
        Gson gson = new Gson();
        return gson.toJson(a);
    }
       
    @GET
    @Path("atualizar")
    public Response atualizar(@QueryParam("id") String id,
                           @QueryParam("generoDoLivro") String generoDoLivro, 
                           @QueryParam("nome") String nome){
        Livro livro = new Livro(generoDoLivro,nome);
        LivrolDAO.getInstance().atualizar(id, livro);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(livro)).build();    
    }
    
    @GET
    @Path("remover")
    public Response remover(@QueryParam("id") int id){
        LivrolDAO.getInstance().remover(id);
        return Response.status(Response.Status.OK).build();
    }
    
}
