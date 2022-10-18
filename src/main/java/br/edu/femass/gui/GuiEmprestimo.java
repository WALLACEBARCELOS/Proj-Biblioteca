package br.edu.femass.gui;

import br.edu.femass.dao.*;

import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private JComboBox cbxExemplares;
    private JComboBox cbxUsuário;
    private JComboBox cbxNome;
    private JList lstEmprestimo;
    private JButton btnSalvar;
    private javax.swing.JPanel JPanel;
    private JButton bntConfirmaUsuário;
    Object Professor = "Professor";
    Object Aluno = "Aluno";

    public GuiEmprestimo() {

        preencherLista();
        preencherListaExemplares();
        cbxUsuário.addItem(Professor);
        cbxUsuário.addItem(Aluno);



        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = (Exemplar) cbxExemplares.getSelectedItem();
                    Leitor leitor = (Leitor) cbxNome.getSelectedItem();
                    Emprestimo emprestimo = new Emprestimo(exemplar, leitor);
                    new DaoEmprestimo().save(emprestimo);
                    new DaoLeitor().save(leitor);
                    preencherLista();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }


            }
        });
        lstEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Exemplar exemplar = (Exemplar) lstEmprestimo.getSelectedValue();
                if(exemplar==null)return;

            }
        });
        bntConfirmaUsuário.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbxUsuário.getSelectedItem() == Professor){
                    preencherListaProfessores();
                }else
                if (cbxUsuário.getSelectedItem() == Aluno){
                    preencherListaAlunos();
                }

            }
        });
    }

    public void preencherLista(){
        try{
            lstEmprestimo.setListData(new DaoEmprestimo().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void preencherListaExemplares(){
        cbxExemplares.removeAllItems();
        try {

            List<Exemplar> exemplares = new DaoExemplar().getAll();
            cbxExemplares.removeAllItems();
            for(Exemplar exemplar : exemplares){
                cbxExemplares.addItem(exemplar);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void preencherListaProfessores(){
        cbxNome.removeAllItems();
        try {
                List<Professor> professores = new DaoProfessor().getAll();
                cbxNome.removeAllItems();
                for(Professor professor : professores){
                    cbxNome.addItem(professor);
                    List<Leitor> leitores = new  DaoLeitor().getAll();
                    leitores.addAll(professores);
                   // this.lstEmprestimo.setListData(leitores.toArray());
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void preencherListaAlunos(){
        cbxNome.removeAllItems();
        try {
                List<Aluno> alunos = new DaoAluno().getAll();
                cbxNome.removeAllItems();
                for (Aluno aluno : alunos) {
                    cbxNome.addItem(aluno);
                    List<Leitor> leitores = new  DaoLeitor().getAll();
                    leitores.addAll(alunos);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void abrirTela(){
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        JDialog frame = new JDialog(new Frame(), true );
        //guiEmprestimo.preencherLista();
        preencherListaExemplares();
        preencherLista();
        preencherListaAlunos();
        frame.setContentPane(guiEmprestimo.JPanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Emprestimo de Exemplar");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiEmprestimo().abrirTela();
    }


}
