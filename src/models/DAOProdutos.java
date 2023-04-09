/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
/**
 *
 * @author mirela
 */
public class DAOProdutos {
    
    private Connection conexao;
    private static DAOProdutos instancia;
    
    private DAOProdutos(){
        try{
            //tenta carregar o driver
            String driverName= "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            //se nao carregar, vai cair na linha do ClassNotFound
            
            //parametros de conexao ao banco
            String host="localhost";
            String db = "cad_loja";
            String url="jdbc:mysql://" + host + "/" + db;
            String user ="root";
            String pwd = "Espetos2"; 
            
            this.conexao = DriverManager.getConnection (url, user, pwd);
            
            //testa
            
            if (this.conexao!=null){
                System.out.println("SUCESSO NA CONEXAO COM BD!");
            }else{
                System.err.println("ERRO NO BD");
       
            }
            
        }
            catch (ClassNotFoundException e){
                
                System.out.println("O driver não foi encontrado");
            }catch (SQLException e){
                System.err.println("Nao foi possivel conectar-se ao banco");
            } 
    }

    
    public void save (String nome, String codigo, String preco, String tipo){
        try{
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO produtos(nome, codigo, preco, tipo)" + "VALUES (?, ?, ?, ?)");

            ps.setString(1, nome);
            ps.setString(2, codigo);
            ps.setString(3, preco);
            ps.setString(4,tipo);
            
            ps.execute();
     } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
            
 
    public static DAOProdutos getInstance()
    {
        if (instancia == null){
            instancia = new DAOProdutos();        
        }
        return instancia;
    
    }
    
    public DefaultListModel<Listar>list(){
        DefaultListModel<Listar>model= new DefaultListModel<>();
        
        try{
            PreparedStatement ps = conexao.prepareStatement ("SELECT * FROM produtos");
            
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                model.addElement(new Listar(
                rs.getString("nome"),
                rs.getString("codigo"),
                rs.getString("preco"),
                rs.getString("tipo"),
                rs.getInt("id")
                ));
            }
            return model;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return null;
    }

}  