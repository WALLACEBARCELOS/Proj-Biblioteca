package br.edu.femass.gui;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private javax.swing.JPanel jPanel;
    private JList lstLivro;
    private JTextField txtTitulo;
    private JComboBox cboAutor;
    private JTextField txtAno;
    private JButton bntSalvar;
    private JButton btnCliente;

    public GuiLivro() {
        lstLivro.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstLivro.getSelectedValue();

                if(livro==null)return;

                txtTitulo.setText(livro.getTitulo());
                txtAno.setText(livro.getAno());
                cboAutor.setSelectedItem(livro.getAutor());


            }
        });
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTela();
                preencherListaAutores();

            }
        });
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtTitulo.getText(), (Autor) cboAutor.getSelectedItem(), txtAno.getText());

                    new DaoLivro().save(livro);
                    preencherLista();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }


            }
        });
    }
    public void preencherLista(){
        try{
            lstLivro.setListData(new DaoLivro().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void preencherListaAutores(){
        cboAutor.removeAllItems();
        try{
            List<Autor> autores = new DaoAutor().getAll();
            for (Autor autor: autores) {
                cboAutor.addItem(autor);
            }
            lstLivro.setListData(new DaoLivro().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void abrirTela(){
        GuiLivro guiLivro = new GuiLivro();

        JDialog frame = new JDialog(new Frame(), true );
        guiLivro.preencherLista();
        guiLivro.preencherListaAutores();
        frame.setContentPane(guiLivro.jPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Livros");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiLivro().abrirTela();
    }


}






















