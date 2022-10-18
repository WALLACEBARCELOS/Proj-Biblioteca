package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import java.util.List;


public class GuiCriarExemplar {
    private JComboBox cbxLivros;
    private JButton bntSalvar;
    private javax.swing.JPanel JPanel;
    private JList lstExemplares;

    public GuiCriarExemplar() {
        preencherListaLivros();
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = (Livro) lstExemplares.getSelectedValue();
                    Exemplar exemplar = new Exemplar((Livro) cbxLivros.getSelectedItem());

                    new DaoExemplar().save(exemplar);
                    preencherLista();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void preencherListaLivros(){
        cbxLivros.removeAllItems();
        try {
            List<Livro> livros = new DaoLivro().getAll();
            cbxLivros.removeAllItems();
            for(Livro livro : livros){
                cbxLivros.addItem(livro);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void preencherLista(){
        try{
            lstExemplares.setListData(new DaoExemplar().getAll().toArray());
        }catch (Exception e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }


    public void abrirTela(){
        GuiCriarExemplar guiCriarExemplar = new GuiCriarExemplar();
        JDialog frame = new JDialog(new Frame(), true );
        guiCriarExemplar.preencherLista();
        guiCriarExemplar.preencherListaLivros();
        frame.setContentPane(guiCriarExemplar.JPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Livros");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiCriarExemplar().abrirTela();
    }

}
