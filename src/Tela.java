import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    private Registro registro;

    public Tela (){
        registro = new Registro();
        b = new ButtonGroup();
        b.add(empresa);
        b.add(individual);

        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoTexto = Integer.parseInt(codigo.getText());
                String nomeTexto = nome.getText();
                if (individual.isSelected()){
                    String cpfTexto = anoCpf.getText();
                    Individual i = new Individual(codigoTexto, nomeTexto, cpfTexto) {
                        @Override
                        public double calculaDesconto() {
                            return 0;
                        }
                    };
                    if (!registro.cadastraCliente(i)){
                        exibeDados.append("Cliente não cadastrado, código repetido.\n");
                    } else {
                        exibeDados.append("Cliente cadastrado com sucesso!\n");
                        registro.cadastraCliente(i);
                    }
                }
                if (empresa.isSelected()){
                    int anoTexto = Integer.parseInt(anoCpf.getText());
                    Empresarial empresa = new Empresarial(codigoTexto, nomeTexto, anoTexto);
                    if (!registro.cadastraCliente(empresa)){
                        exibeDados.append("Cliente não cadastrado, código repetido.\n");
                    } else {
                        exibeDados.append("Cliente cadastrado com sucesso!\n");
                        registro.cadastraCliente(empresa);
                    }
                }
                registro.organizarLista();
            }
        });
        imprime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < registro.getLista().size(); i++) {
                    exibeDados.append(registro.getLista().get(i).toString());
                }
            }
        });
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.setText("");
                nome.setText("");
                anoCpf.setText("");
                exibeDados.setText("");
                b.clearSelection();
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
