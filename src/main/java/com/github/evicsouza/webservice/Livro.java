/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.evicsouza.webservice;

/**
 *
 * @author Eva
 */
public class Livro {
    
    int id;
    private String generoDoLivro;
    private String nome;
    
    public Livro(int id, String generoDoLivro, String nome){
        this.id = id;
        this.generoDoLivro = generoDoLivro;
        this.nome = nome;
    }
    public Livro(String generoDoLivro, String nome){
        this.generoDoLivro = generoDoLivro;
        this.nome = nome;
    }
    public Livro (int id){ //por cauda do listar pelo id
        this.id = id;
    }
    public String getGeneroDoLivro(){
        return generoDoLivro;
    }
    public void setGeneroDoLivro(String generoDoLivro){
        this.generoDoLivro = generoDoLivro;
    }
    public String getLivro(){
        return nome;
    }
    public void setLivro(String nome){
        this.nome = nome;
    }
    
}
