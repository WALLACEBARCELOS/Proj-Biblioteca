package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiDevolucao {
    private javax.swing.JPanel Jpanel;
    private JComboBox cbxExemplar;
    private JButton bntDevolver;

    public GuiDevolucao() {
        preencherListaExemplar();

        bntDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void preencherListaExemplar(){
        cbxExemplar.removeAllItems();
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            cbxExemplar.removeAllItems();
            for (Emprestimo emprestimo : emprestimos) {
                cbxExemplar.addItem(emprestimo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void abrirTela(){
        GuiDevolucao guiDevolucao = new GuiDevolucao();
        JDialog frame = new JDialog(new Frame(), true );
        preencherListaExemplar();
        frame.setContentPane(guiDevolucao.Jpanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Livros");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiDevolucao().abrirTela();
    }
}
