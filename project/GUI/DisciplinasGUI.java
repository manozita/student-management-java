package GUI;
import app.*;
import entities.*;
import saida.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author manoela
*/

public class DisciplinasGUI extends javax.swing.JFrame {
    
    ISaida saida = new Saida(); // para entradas em modo grafico
    
    // declaracao de variaveis
    private JLabel txtDiscDisciplinas, txtDiscAluno, txtDiscCodigo, txtDiscNome, txtDiscNota;
    private JTextField fieldDiscCodigo, fieldDiscNome, fieldDiscNota;
    private JButton btnDiscAdicionar, btnDiscVoltar;
    private JTable tableDiscDisciplinas;
    private JScrollPane scrollTableDisc;
    private DefaultTableModel tableModel;
    private String ra;

    public DisciplinasGUI(String ra, DefaultTableModel tableModel) {
        this.ra = ra;
        this.tableModel = tableModel;
        setSize(600, 650);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        // titulo
        txtDiscDisciplinas = new JLabel("Disciplinas");
        txtDiscDisciplinas.setFont(new Font("Arial Black", Font.PLAIN, 36));
        txtDiscDisciplinas.setBounds(180, 20, 300, 50);
        add(txtDiscDisciplinas);
        
        if (ra != null) {
            txtDiscAluno = new JLabel("Aluno RA" + ra);
            txtDiscAluno.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
            txtDiscAluno.setBounds(200, 80, 250, 50);
            add(txtDiscAluno);
        }

        txtDiscCodigo = new JLabel("Código");
        txtDiscCodigo.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtDiscCodigo.setBounds(50, 150, 100, 30);
        add(txtDiscCodigo);

        fieldDiscCodigo = new JTextField();
        fieldDiscCodigo.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldDiscCodigo.setBounds(200, 150, 300, 30);
        add(fieldDiscCodigo);

        txtDiscNome = new JLabel("Nome");
        txtDiscNome.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtDiscNome.setBounds(50, 200, 100, 30);
        add(txtDiscNome);

        fieldDiscNome = new JTextField();
        fieldDiscNome.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldDiscNome.setBounds(200, 200, 300, 30);
        add(fieldDiscNome);

        txtDiscNota = new JLabel("Nota");
        txtDiscNota.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtDiscNota.setBounds(50, 250, 100, 30);
        add(txtDiscNota);

        fieldDiscNota = new JTextField();
        fieldDiscNota.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldDiscNota.setBounds(200, 250, 300, 30);
        add(fieldDiscNota);

        btnDiscAdicionar = new JButton("Adicionar");
        btnDiscAdicionar.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        btnDiscAdicionar.setBounds(50, 325, 200, 30);
        add(btnDiscAdicionar);
        btnDiscAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscAdicionarActionPerformed(evt);
            }
        });
        
        btnDiscVoltar = new JButton("Voltar");
        btnDiscVoltar.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        btnDiscVoltar.setBounds(350, 325, 200, 30);
        add(btnDiscVoltar);
        btnDiscVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        tableDiscDisciplinas = new JTable(tableModel);
        scrollTableDisc = new JScrollPane(tableDiscDisciplinas);
        scrollTableDisc.setBounds(50, 400, 500, 150);
        add(scrollTableDisc);
        setLocationRelativeTo(null);
    }

    private void btnDiscAdicionarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // recuperar dados preenchidos no form
        String itens[] = {fieldDiscNome.getText(), fieldDiscCodigo.getText(), fieldDiscNota.getText()};
        
        String nomes[] = {"nome", "codigo", "nota"};
        String erro = "ERROS:";
        
        for (int i = 0; i < itens.length; i++) {
            if (itens[i].isEmpty())
                erro += ("\nCampo " + nomes[i] + " nao pode estar vazio.");
        }

        int checkNota = Utils.isNumeric(itens[2]);
        if (checkNota != 3 && ((checkNota != 0.0 && Float.parseFloat(itens[2])>10 || Float.parseFloat(itens[2])<0) || Float.parseFloat(itens[2])<0)) {
            erro += ("\nCampo " + nomes[2] + " invalido.");
            fieldDiscNota.setText("");
        }
        
        if ("ERROS:".equals(erro)) {
            DefaultTableModel tabelaDisciplinas = (DefaultTableModel) tableDiscDisciplinas.getModel();
            String dados[] = {itens[0], itens[1], itens[2]};
            fieldDiscNome.setText(""); fieldDiscCodigo.setText(""); fieldDiscNota.setText("");
            tableModel.addRow(dados);
        } else
            saida.imprimirErro("FALHA NA LEITURA",erro);
    }     
}
