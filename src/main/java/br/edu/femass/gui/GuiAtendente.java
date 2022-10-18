package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAtendente {
    private JButton cadastrarAlunoButton;
    private JPanel Jpanel;
    private JButton cadastrarProfessorButton;
    private JButton realizarEmprestimoButton;
    private JButton realizarDevoluçãoButton;

    public GuiAtendente() {
        cadastrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiCadastrarAluno().abrirTela();
            }
        });
        cadastrarProfessorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiProfessor().abrirTela();
            }
        });
        realizarEmprestimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();

            }
        });
        realizarDevoluçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiDevolucao().abrirTela();
            }
        });

    }

    public void abrirTela(){
        GuiAtendente guiAtendente = new GuiAtendente();

        JDialog frame = new JDialog(new Frame(), true );
        frame.setContentPane(guiAtendente.Jpanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Aluno");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }
}
