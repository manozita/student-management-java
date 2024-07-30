package GUI;
import cadastro.*;
import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {

    private JLabel txtMenuTitulo;
    private JButton btnMenuCadastrar;
    private JButton btnMenuRemover;
    private JButton btnMenuListar;
    private JButton btnMenuLer;
    private JButton btnMenuSalvar;
    private JButton btnMenuSair;
    private Cadastro cad = new Cadastro();
    private CadastroGUI menuCadastro;

    public MenuGUI() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setSize(265, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        txtMenuTitulo = new JLabel("Menu de Cadastro");
        txtMenuTitulo.setFont(new Font("Arial Black", Font.PLAIN, 24));
        txtMenuTitulo.setBounds(10, 10, 245, 50);

        btnMenuCadastrar = new JButton("CADASTRAR ALUNO");
        btnMenuCadastrar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        btnMenuCadastrar.setBounds(35, 80, 195, 40);
        btnMenuCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastro = new CadastroGUI(cad);
                menuCadastro.setVisible(true);
            }
        });

        btnMenuRemover = new JButton("REMOVER ALUNO");
        btnMenuRemover.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        btnMenuRemover.setBounds(35, 130, 195, 40);
        btnMenuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad.removerAluno();
            }
        });

        btnMenuListar = new JButton("LISTAR ALUNOS");
        btnMenuListar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        btnMenuListar.setBounds(35, 180, 195, 40);
        btnMenuListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad.listarAluno();
            }
        });
        
        btnMenuLer = new JButton("LER ARQUIVO");
        btnMenuLer.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        btnMenuLer.setBounds(35, 230, 195, 40);
        btnMenuLer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad.lerArquivo();
            }
        });
        
        btnMenuSalvar = new JButton("SALVAR PROGRESSO");
        btnMenuSalvar.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
        btnMenuSalvar.setBounds(35, 280, 195, 40);
        btnMenuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad.salvarProgresso();
            }
        });
        
        btnMenuSair = new JButton("SAIR");
        btnMenuSair.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        btnMenuSair.setBounds(35, 330, 195, 40);
        btnMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        
        add(txtMenuTitulo);
        add(btnMenuCadastrar);
        add(btnMenuRemover);
        add(btnMenuListar);
        add(btnMenuLer);
        add(btnMenuSalvar);
        add(btnMenuSair);
        setLocationRelativeTo(null);
    }
}
