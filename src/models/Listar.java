/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mirela
 */
public class Listar{
    private int id;
    private String nome;
    private String codigo;
    private String preco;
    private String tipo;
    
    public Listar(String nome, String codigo, String preco, String tipo){
        this.nome=nome;
        this.codigo=codigo;
        this.preco=preco;
        this.tipo=tipo;
    }
    
     public Listar(String nome, String codigo, String preco, String tipo, int id){
        this.nome=nome;
        this.codigo=codigo;
        this.preco=preco;
        this.tipo=tipo;
        this.id=id;
    }
     
     @Override
     public String toString(){
         return this.nome;
     }
    
    
}
