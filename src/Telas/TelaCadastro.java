/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import ouvintes.ListenerSalvar;

/**
 *
 * @author mirela
 */
public class TelaCadastro extends JDialog{
    
    //atributos
    private JPanel panel;
    
    //elementos da tela
    
    private JLabel label_nome;
    private JLabel label_codigo;
    private JLabel label_preco;
    private JLabel label_tipo;
    
    private JTextField text_nome;
    private JTextField text_codigo;
    private JTextField text_preco;
    private JTextField text_tipo;
    
    private JButton bt_salva;
    private JButton bt_cancela;
         
    
    public TelaCadastro (){
        this.initialize();
        
        this.setModal(true);
        this.setVisible(true);
    }
    
    //inicializacao da janela
    public void initialize(){
        
        //cria novo objeto para o JPanel
        panel = new JPanel();
        
        //grid layout 5 linhas e 2 colunas      
        GridLayout gl = new GridLayout (5, 2, 10, 10);
        panel.setLayout(gl);
        
        //seta o tamanho e posicao da janela
        this.setBounds(0, 0 , 400, 200);
        
        //inicializacao 
        label_nome = new JLabel("Nome do Produto");
        label_codigo = new JLabel ("Codigo");
        label_preco = new JLabel ("preco");
        label_tipo = new JLabel ("tipo");
        
        text_nome = new JTextField ();
        text_codigo = new JTextField ();
        text_preco = new JTextField ();
        text_tipo = new JTextField ();
        
        bt_salva = new JButton ("Salvar");
        bt_cancela = new JButton ("Cancelar");
        
        //configuracao
        
        //evento de clique
        bt_salva.addActionListener(new ListenerSalvar( text_nome, text_codigo, text_preco, text_tipo));
        bt_cancela.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        }
        );
        //adicionar ao painel
        
        panel.add(label_nome);
        panel.add(text_nome);
        panel.add(label_codigo);
        panel.add(text_codigo);
        panel.add(label_preco);
        panel.add(text_preco);
        panel.add(label_tipo);
        panel.add(text_tipo);
        panel.add(bt_salva);
        panel.add(bt_cancela);
    
        //addd o panel no Frame
        this.add(panel);
        
        //define o tamanho default
        this.setPreferredSize(new Dimension(400,200));
        
        //define o titulo
        this.setTitle("Cadastro de Produtos");
       
        this.pack();
        
        this.setLocationRelativeTo(null);
        
        //define que quando fechar a tela o programa acaba
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
