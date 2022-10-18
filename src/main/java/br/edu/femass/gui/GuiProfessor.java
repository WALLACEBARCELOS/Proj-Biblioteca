package br.edu.femass.gui;



import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProfessor {
    private JList lstProfessor;
    private JTextField txtDiciplina;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JButton bntSalvar;
    private JPanel Jpanel;

    public GuiProfessor() {
        lstProfessor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Professor professor = (Professor) lstProfessor.getSelectedValue();

                if(!(professor==null)){
                    txtDiciplina.setText((professor.getDiciplina()));
                    txtNome.setText((professor.getNome()));
                    txtEndereco.setText((professor.getEndereco()));
                    txtTelefone.setText((professor.getTelefone()));
                }

            }
        });



        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Professor professor = new Professor(txtDiciplina.getText(),txtNome.getText(),txtEndereco.getText(), txtTelefone.getText());
                    new DaoProfessor().save(professor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                preencherLista();

            }
        });
    }

    public void preencherLista(){
        try{
            lstProfessor.setListData(new DaoProfessor().getAll().toArray());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public void abrirTela(){
        GuiProfessor guiProfessor = new GuiProfessor();

        JDialog frame = new JDialog(new Frame(), true );
        guiProfessor.preencherLista();
        frame.setContentPane(guiProfessor.Jpanel);
        //fechar o programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Professor");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(1000,250);
    }

    public static void main(String[] args) {
        new GuiProfessor().abrirTela();
    }


}
