package br.edu.femass.gui;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarAluno {
    private JTextField txtMatricula;
    private JList lstAluno;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JButton btnSalvar;
    private JPanel JPanel;

    public GuiCadastrarAluno() {

        //SALAVA OS DADOS NO DAO ALUNO
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(txtMatricula.getText(),txtNome.getText(),txtEndereco.getText(), txtTelefone.getText());
                    new DaoAluno().save(aluno);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                preencherLista();
            }
        });



        //Mostra qual o elemento selecionado no array dentro do TXT.
        lstAluno.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAluno.getSelectedValue();

                if(!(aluno==null)){
                    txtMatricula.setText((aluno.getMatricula()));
                    txtNome.setText((aluno.getNome()));
                    txtEndereco.setText((aluno.getEndereco()));
                    txtTelefone.setText((aluno.getTelefone()));
                }
            }
        });

    }

    public void preencherLista(){
        try{
            lstAluno.setListData(new DaoAluno().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void abrirTela(){
        GuiCadastrarAluno guiAluno = new GuiCadastrarAluno();

        JDialog frame = new JDialog(new Frame(), true );
        guiAluno.preencherLista();
        frame.setContentPane(guiAluno.JPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Aluno");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiCadastrarAluno().abrirTela();
    }

}