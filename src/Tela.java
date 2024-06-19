import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela {
    private JTextField codigo;
    private JTextField nome;
    private JRadioButton individual;
    private JRadioButton empresa;
    private JButton confirma;
    private JButton sair;
    private JButton limpar;
    private JTextField anoCpf;
    private JButton imprime;
    private JTextArea exibeDados;
    private JPanel Painel;
    private ButtonGroup b;

    public Tela (){

        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = anoCpf.getText();
                exibeDados.append(texto);
                if (individual.isSelected()){

                    exibeDados.append("individual");
                }
                if (empresa.isSelected()){
                    exibeDados.append("empresarial");
                }
            }
        });
        imprime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibeDados.append("fkjfjfjfj\n");
            }
        });
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.setText("");
                nome.setText("");
                exibeDados.setText("");
            }
        });
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public JPanel getPainel(){
        return Painel;
    }
}
