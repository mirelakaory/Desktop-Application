/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.DAOProdutos;

/**
 *
 * @author mirela
 */
public class ListenerSalvar implements ActionListener 
{
    private JTextField nome;
    private JTextField codigo;
    private JTextField preco;
    private JTextField tipo;
    
    public ListenerSalvar (JTextField nome, JTextField codigo, JTextField preco, JTextField tipo){
       this.nome=nome;
       this.codigo=codigo;
       this.preco=preco;
       this.tipo=tipo;
       
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        DAOProdutos dao = DAOProdutos.getInstance();
        dao.save(nome.getText(), codigo.getText(), preco.getText(), tipo.getText());
        
        System.out.println("Salvo com sucesso!");
    }
}
