/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.evicsouza.webservice;

import java.util.ArrayList;

/**
 *
 * @author Eva
 */
public class LivrolDAO {
    
    private static LivrolDAO instance;
     static private ArrayList<Livro> livros;
     static int id;
     
     private LivrolDAO(){
         id = 1;
         this.livros = new ArrayList<Livro>();
         Livro a1 =  new Livro("cachorro", "bolinha");
         salvar(a1);
         Livro a2 =  new Livro("gato", "pelinho");
         salvar(a2);
     }
    //só pode instanciar uma vez
    public static LivrolDAO getInstance(){
        if(instance == null){
            instance = new LivrolDAO();
        }
        return instance;
    }
    
    //salva o animal no array mudando seu id
    public boolean salvar(Livro a){
        a.id = id;
        id++;
        return this.livros.add(a);
    }
    
    public ArrayList<Livro> listarTodos(){
        return this.livros;
    }
       
    public Livro listarPorId(Livro a){
        for(int i=0; i<this.livros.size(); i++){
            if(this.livros.get(i).id == a.id){
                a = this.livros.get(i);
                return this.livros.get(i);
            }
        }
        return a;
    }
    
    public boolean atualizar(String id, Livro a){
        for(int i=0; i<this.livros.size(); i++){
            if(this.livros.get(i).id == a.id)
                this.livros.set(i,a);
                return true;
        }
        return false;
    }
    
    public boolean remover(int id){
        this.livros.remove(id);
        return true;
    }
    
}
