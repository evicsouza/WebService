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
public class LivroDAO {
    
    private static LivroDAO instance;
     static private ArrayList<Livro> livros;
     static int id;
     
     private LivroDAO(){
         id = 1;
         this.livros = new ArrayList<Livro>();
         Livro a1 =  new Livro("romance", "Segredos de Emma");
         salvar(a1);
         Livro a2 =  new Livro("infantil", "Cinderela");
         salvar(a2);
     }
    //só pode instanciar uma vez
    public static LivroDAO getInstance(){
        if(instance == null){
            instance = new LivroDAO();
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
    
    public Livro atualizar(Livro a){
        int index = pegarIndex(a);
        livros.set(index,a);
        return listarPorId(a);
        
        
    }
    
    public boolean remover(Livro a){
        int index = pegarIndex(a);
        this.livros.remove(index);
        return true;
    }
        public int pegarIndex(Livro a){
    int index = -1;
    for(int i=0;i<livros.size();i++){
        if(livros.get(i).id == a.id){
            index = i;
        }
    }
    return index;
    
    }
    
}
