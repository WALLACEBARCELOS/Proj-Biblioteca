package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecario {
    private javax.swing.JPanel JPanel;
    private JButton cadastrarLivroButton;
    private JButton cadastrarExemplarButton;
    private JButton cadastrarAutorButton;
    private JButton btxAtraso;

    public GuiBibliotecario() {
        cadastrarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLivro().abrirTela();

            }
        });
        cadastrarExemplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiCriarExemplar().abrirTela();

            }
        });
        cadastrarAutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTela();
            }
        });
        btxAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAtraso().abrirTela();
            }
        });
    }

    public void abrirTela(){
        GuiBibliotecario guiBibliotecario = new GuiBibliotecario();

        JDialog frame = new JDialog(new Frame(), true );
        frame.setContentPane(guiBibliotecario.JPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Bibliotecario");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }


}
