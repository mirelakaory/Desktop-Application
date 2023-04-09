/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import models.DAOProdutos;
import models.Listar;

/**
 *
 * @author mirela
 */

public class Principal extends JFrame {
    
    private JPanel panel;
    private JPanel panel_botoes;
    
    private JButton bt_novo;
    private JButton bt_deletar;
    private JButton bt_sair;
    
    private JLabel label_title;
    
    private JMenuBar b_menu;
    
    private JMenu menu_programa;
    
    private JMenuItem item_cadastro;
    private JMenuItem item_sair;
    
    
    private JList<Listar> lista;
    private JScrollPane scroll_lista;
    
    private DAOProdutos dao;
    
    //inicializacao
    
    public void initialize(){
        
        
        //botoes
        bt_novo = new JButton ("Novo");
        bt_deletar = new JButton ("Apagar");
        bt_sair = new JButton ("Sair");
        
        //titulo
        
        label_title = new JLabel ("Listagem de Produtos ");
        
        //paineis
        setVisible(true);
        panel = new JPanel ();
        panel_botoes = new JPanel();
        b_menu= new JMenuBar();
        menu_programa = new JMenu("Programa");
        item_cadastro = new JMenuItem ("Cadastrar produto");
        item_sair = new JMenuItem ("Sair");
  
       //layout do painel total
       panel.setLayout (new BorderLayout (5,5));
       
       //tamanho da janela
       
       this.setBounds (0,0,600,300);
       this.setPreferredSize(new Dimension (600,300));
       
       //configuracao da listagem
       //configura o painel
       lista=new JList<>();
       
       lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       lista.setLayoutOrientation(JList.VERTICAL);
       lista.setModel(dao.list());
       lista.setVisibleRowCount(-1);
       
       scroll_lista=new JScrollPane(lista);
       panel.add(scroll_lista, BorderLayout.CENTER);
       
       
       //adicao de elementos
       panel.add(label_title, BorderLayout.PAGE_START);
       
       //subpainel de botoes
       
       panel_botoes.setLayout (new GridLayout (6,1,10,10));
       
        //configura os botoes
        bt_sair.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){
            setVisible (false);
            dispose();
        }
        });
        bt_novo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                TelaCadastro c = new TelaCadastro();
            }
        });
       
        
        //adiciona
        panel_botoes.add(bt_novo);
        panel_botoes.add(bt_deletar);
        panel_botoes.add(bt_sair);
        
        //coloca o subpanel no painel mae
        
        panel.add(panel_botoes, BorderLayout.LINE_END);
        
        //adiciona o panel no Frame
        this.add(panel);
        this.pack ();
        
        //define o titulo da janela
        this.setTitle ("Cadastro de Produtos");
        
        //exibe
        this.setVisible(true);
        
        this.setLocationRelativeTo(null);
        
        //define que qunando fechar a janela, o programa acaba
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //configuracao do menu
        
        //adicao dos itens do menu
        
        menu_programa.add(item_cadastro);
        menu_programa.addSeparator();
        menu_programa.add(item_sair);
        
        b_menu.add(menu_programa);
        
        this.setJMenuBar(b_menu); //seta o menu
        
        //configura o item do menu
        
        item_sair.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        
        item_cadastro.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            TelaCadastro c = new TelaCadastro();
            }
        });
 
    }
       
    public Principal(){     
            this.dao = DAOProdutos.getInstance();
            
            this.initialize();
            this.setExtendedState(NORMAL);
 
        }
    }
    
 
