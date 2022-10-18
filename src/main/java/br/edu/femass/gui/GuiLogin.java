package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

public class GuiLogin {
    protected JComboBox cbxUsuario;
    private JPanel Jpanel;
    private JPasswordField pswSenha;
    private JButton bntLogin;

    Object Atendente = "Atendente";
    Object Bibliotecario = "Bibliotecario";

    public GuiLogin(){
        cbxUsuario.addItem(Bibliotecario);
        cbxUsuario.addItem(Atendente);


        bntLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cbxUsuario.getSelectedItem() == Bibliotecario){
                    new GuiBibliotecario().abrirTela();
                }
                else{
                    new GuiAtendente().abrirTela();
                }
            }
        });
    }

    public void abrirTela(){
        GuiLogin guiLogin = new GuiLogin();

        JFrame frame = new JFrame();
        frame.setContentPane(guiLogin.Jpanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Tela Login");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiLogin().abrirTela();
    }
}



