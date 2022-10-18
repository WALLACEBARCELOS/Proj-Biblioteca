package br.edu.femass.gui;

import br.edu.femass.dao.*;
import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAtraso {
    private JPanel Jpanel;
    private JList lstAtraso;
    private JButton bnxCarregar;

    public GuiAtraso() {

        preencherLista();
        lstAtraso.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Leitor leitor = (Leitor) lstAtraso.getSelectedValue();
                if(leitor==null)return;
            }
        });
        bnxCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void preencherLista(){
        try{
            lstAtraso.setListData(new DaoLeitor().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void abrirTela(){
        GuiAtraso guiAtraso = new GuiAtraso();

        JDialog frame = new JDialog(new Frame(), true );
        frame.setContentPane(guiAtraso.Jpanel);
        preencherLista();
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Aluno");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }
}
