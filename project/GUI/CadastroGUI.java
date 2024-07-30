package GUI;
import cadastro.*;
import entities.*;
import saida.*;
import entrada.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
/**
*
* @author manoela
*/
public class CadastroGUI extends javax.swing.JFrame {
    ISaida saida = new Saida(); // para saidas em modo grafico
    IEntrada entrada = new Entrada(); // para entradas em modo grafico
    
    // declaracao de variaveis
    private JLabel txtCadCadastro, txtCadNome, txtCadIdade, txtCadRA, txtCadRG, txtCadSemestre, txtCadCurso;
    private JTextField fieldCadNome, fieldCadIdade, fieldCadRA, fieldCadRG;
    private JComboBox<String> cboxCadSemestre, cboxCadCurso;
    private JButton btnCadDisciplinas, btnCadInserir;
    private JTable tableCadDisciplinas;
    private JScrollPane scrollTableCad;
    private DefaultTableModel tableModel;
    private Aluno novoAluno;
    private Cadastro cad;

    public CadastroGUI(Cadastro cad) {
        this.cad = cad;
        inicializarComponentes();
    }
 
    /**
     * inicializa a forma do JFrame
     */                     
    private void inicializarComponentes() {
        setSize(600, 650); // tamanho do JFrame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ao clicar no X, encerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closePage();
            }   
        });
        setLayout(null);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome da Disciplina", "Codigo", "Nota" });
 
        // titulo
        txtCadCadastro = new JLabel("Cadastro");
        txtCadCadastro.setFont(new Font("Arial Black", Font.PLAIN, 36));
        txtCadCadastro.setBounds(200, 20, 200, 50);
        add(txtCadCadastro);
        // nome do aluno
        txtCadNome = new JLabel("Nome");
        txtCadNome.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadNome.setBounds(50, 100, 100, 30);
        add(txtCadNome);
        fieldCadNome = new JTextField();
        fieldCadNome.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldCadNome.setBounds(200, 100, 300, 30);
        add(fieldCadNome);
 
        // idade do aluno
        txtCadIdade = new JLabel("Idade");
        txtCadIdade.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadIdade.setBounds(50, 150, 100, 30);
        add(txtCadIdade);
 
        fieldCadIdade = new JTextField();
        fieldCadIdade.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldCadIdade.setBounds(200, 150, 300, 30);
        add(fieldCadIdade);
        // ra do aluno
        txtCadRA = new JLabel("RA");
        txtCadRA.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadRA.setBounds(50, 200, 100, 30);
        add(txtCadRA);
 
        fieldCadRA = new JTextField();
        fieldCadRA.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldCadRA.setBounds(200, 200, 300, 30);
        add(fieldCadRA);
 
        // rg do aluno
        txtCadRG = new JLabel("RG");
        txtCadRG.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadRG.setBounds(50, 250, 100, 30);
        add(txtCadRG);
 
        fieldCadRG = new JTextField();
        fieldCadRG.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        fieldCadRG.setBounds(200, 250, 300, 30);
        add(fieldCadRG);
 
        // semestre do aluno
        txtCadSemestre = new JLabel("Semestre");
        txtCadSemestre.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadSemestre.setBounds(50, 300, 100, 30);
        add(txtCadSemestre);
 
        cboxCadSemestre = new JComboBox<>();
        cboxCadSemestre.addItem("Escolher...");
        for (int i = 1; i <= 10; i++) { // adiciona semestres de 1 a 10
            cboxCadSemestre.addItem(String.valueOf(i));
        }
        cboxCadSemestre.setBounds(200, 300, 300, 30);
        add(cboxCadSemestre);
 
        // curso do aluno
        txtCadCurso = new JLabel("Curso");
        txtCadCurso.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        txtCadCurso.setBounds(50, 350, 100, 30);
        add(txtCadCurso);
 
        cboxCadCurso = new JComboBox<>();
        cboxCadCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Escolher...", "Design", "Engenharia Biomedica", "Engenharia Civil", "Engenharia de Sistemas Ciberfisicos", "Jogos Digitais", "Ciencia da Computacao"}));
        cboxCadCurso.setBounds(200, 350, 300, 30);
        add(cboxCadCurso);
        // botao das disciplinas
        btnCadDisciplinas = new JButton("Disciplinas");
        btnCadDisciplinas.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        btnCadDisciplinas.setBounds(50, 400, 200, 30);
        add(btnCadDisciplinas);
        // definindo acao de clique das disciplinas
        btnCadDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadDisciplinasActionPerformed(evt);
            }
        });
 
        // botao de insercao
        btnCadInserir = new JButton("Inserir");
        btnCadInserir.setFont(new Font("Arial Narrow", Font.PLAIN, 24));
        btnCadInserir.setBounds(300, 400, 200, 30);
        add(btnCadInserir);
        // definindo acao de clique de inserir
        btnCadInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadInserirActionPerformed(evt);
            }
        });
 
        // tabela de disciplinas
        tableCadDisciplinas = new JTable(tableModel);
        scrollTableCad = new JScrollPane(tableCadDisciplinas);
        scrollTableCad.setBounds(50, 450, 500, 150);
        add(scrollTableCad);
        setLocationRelativeTo(null);
    }
    private void btnCadDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {
        String entrada = fieldCadRA.getText();
        if (!fieldCadRA.getText().matches("\\d{8}"))
            entrada = null;
        new DisciplinasGUI(entrada, (DefaultTableModel) tableCadDisciplinas.getModel()).setVisible(true);
    }
 
    public void btnCadInserirActionPerformed(java.awt.event.ActionEvent evt) {    
        String itens[] = {fieldCadNome.getText(), fieldCadIdade.getText(), fieldCadRA.getText(), fieldCadRG.getText(), 
            cboxCadSemestre.getSelectedItem().toString(), cboxCadCurso.getSelectedItem().toString()};
        String nomes[] = {"nome", "idade", "RA", "RG", "semestre", "curso"};
        String erro = "ERROS:";
        for (int i = 0; i < itens.length; i++) {
            if (itens[i].isEmpty())
                erro += ("\nCampo " + nomes[i] + " nao pode estar vazio.");
        }
        if (Utils.isNumeric(itens[1]) != 1 && Utils.isNumeric(itens[1]) != 3) {
            erro += ("\nCampo " + nomes[1] + " invalido.");
            fieldCadIdade.setText("");
        }
        if (!itens[2].matches("\\d{8}") && Utils.isNumeric(itens[2]) != 3) {
            erro += ("\nCampo " + nomes[2] + " invalido.");
            fieldCadRA.setText("");
        }
        if (!itens[3].matches("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}") && !itens[3].matches("\\d{9}") && Utils.isNumeric(itens[3]) != 3) {
            erro += ("\nCampo " + nomes[3] + " invalido.");
            fieldCadRG.setText("");
        }
        else if (itens[3].matches("\\d{9}"))
            itens[3] = itens[3].substring(0, 2) + "." + itens[3].substring(2, 5) + "." + itens[3].substring(5, 8) + "-" + itens[3].substring(8, 9);
        if ("Escolher...".equals(itens[4]) || "Escolher...".equals(itens[5])) {
            erro += ("\nNecessario escolher uma opcao para semestre e curso.");
        }
        else {
            switch (itens[5]) {
                case "Design":
                    itens[5] = "DE";
                    break;
                case "Engenharia Biomedica":
                    itens[5] = "ENG BIO";
                    break;
                case "Engenharia Civil:":
                    itens[5] = "ENG Civil";
                    break;
                case "Engenharia de Sistemas Ciberfisicos":
                    itens[5] = "ENG Ciber";
                    break;
                case "Jogos Digitais":
                    itens[5] = "JD";
                    break;
                case "Ciencia da Computacao":
                    itens[5] = "CC";
                    break;
            }
        }
        if ("ERROS:".equals(erro)) {
            novoAluno = new Aluno(itens[0], Integer.parseInt(itens[1]), itens[3], itens[2], itens[5], Integer.parseInt(itens[4]), getTabelaDeDisciplinas());
            cad.inserirAluno(novoAluno);
            dispose();
        } else {
            saida.imprimirErro("FALHA NA LEITURA",erro);
        }
    }  
    
    public String getRA() {
        return fieldCadRA.getText();
    }
    
    private Disciplina[] getTabelaDeDisciplinas() {
        int numDisciplinas = tableCadDisciplinas.getRowCount();
        Disciplina[] disciplinas = new Disciplina[numDisciplinas];
        for (int i = 0; i < numDisciplinas; i++) {
            disciplinas[i] = new Disciplina(tableCadDisciplinas.getValueAt(i, 1).toString(), tableCadDisciplinas.getValueAt(i, 0).toString(), Float.parseFloat(tableCadDisciplinas.getValueAt(i, 2).toString()));
        }
        return disciplinas;
    }
    
    public void closePage() {
        boolean empty = true;
        String itens[] = {fieldCadNome.getText(), fieldCadIdade.getText(), fieldCadRA.getText(), fieldCadRG.getText(), 
            cboxCadSemestre.getSelectedItem().toString(), cboxCadCurso.getSelectedItem().toString()};
        for (int i = 0; i < itens.length-2; i++) {
            if (!itens[i].isEmpty())
                empty = false;
        }
        if (!"Escolher...".equals(itens[4]) || !"Escolher...".equals(itens[5])) {
            empty = false;
        }
        
        if (empty == false) {
            int opc = entrada.imprimirPergunta("Voce tem alteracoes nao salvas. Deseja continuar?");
            if(opc == JOptionPane.NO_OPTION)
                dispose();
        } else
            dispose();
    }
    
}