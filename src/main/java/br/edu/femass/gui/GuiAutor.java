package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAutor {
    private JTextField TxtNome;
    private JTextField TxtSobrenome;
    private JTextField TxtNacionalidade;
    private JButton BtnSalvar;
    private javax.swing.JPanel JPanel;
    private JList lstAutores;
    private JList LstAutor;

    public GuiAutor() {
        BtnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                Autor autor = new Autor(TxtNome.getText(),TxtSobrenome.getText(), TxtNacionalidade.getText());
                    new DaoAutor().save(autor);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                preencherLista();
            }
        });
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();

                if(!(autor==null)){
                    TxtNome.setText(autor.getNome());
                    TxtNacionalidade.setText(autor.getNacionalidade());
                    TxtSobrenome.setText(autor.getSobreNome());
                }

            }
        });
    }

    public void preencherLista(){
        try{
            lstAutores.setListData(new DaoAutor().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void abrirTela(){
        GuiAutor guiAutor = new GuiAutor();

        JDialog frame = new JDialog(new Frame(), true );
        guiAutor.preencherLista();
        frame.setContentPane(guiAutor.JPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Autores");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiAutor().abrirTela();
    }


}
