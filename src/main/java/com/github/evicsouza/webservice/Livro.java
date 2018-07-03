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
    private String gereroDoLivro;
    private String nome;
    
    public Livro(String generoDoLivro, String nome){
        this.gereroDoLivro = generoDoLivro;
        this.nome = nome;
    }
    public Livro (int id){ //por cauda do listar pelo id
        this.id = id;
    }
    public String getGereroDoLivro(){
        return gereroDoLivro;
    }
    public void setGereroDoLivro(String gereroDoLivro){
        this.gereroDoLivro = gereroDoLivro;
    }
    public String getLivro(){
        return nome;
    }
    public void setLivro(String nome){
        this.nome = nome;
    }
    
}
