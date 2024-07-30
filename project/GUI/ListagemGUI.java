package GUI;
import app.*;
import cadastro.*;
import entities.*;
import saida.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
/**
* Write a description of class Listagem here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class ListagemGUI extends JFrame
{
    private ISaida saida = new Saida();
    private JPanel JPanelList;
    private JScrollPane scrollList;
    private JLabel lblTituloList;
    private JButton btnOkList;
    private DefaultTableModel modelList;
    private JTable tabAlunosList;
    private Menu frameMenuList;
    private IArmazenador listaAlunos;
    
    /**
     * construtor
     */
    public ListagemGUI(IArmazenador listaAlunos)
    {
        this.listaAlunos = listaAlunos;
        inicializarComponentes();
    }
    
    private void inicializarComponentes()
    {
        setSize(3000,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanelList = new JPanel();
        JPanelList.setLayout(new BoxLayout(JPanelList, BoxLayout.Y_AXIS));
        JPanelList.setPreferredSize(new Dimension(1000, 600));
 
        lblTituloList = new JLabel("Lista de Alunos", SwingConstants.CENTER);
        lblTituloList.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanelList.add(lblTituloList);
 
        modelList = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Idade", "RG", "RA", "Curso", "Semestre", "Disciplinas" });
        adicionarDados();
        
        tabAlunosList = new JTable(modelList);
        scrollList = new JScrollPane(tabAlunosList); 
        JPanelList.add(scrollList);
        tabAlunosList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                escolhaAlunoTabela(evt);
            }
        });
        
        
        btnOkList = new JButton("OK");
        btnOkList.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanelList.add(btnOkList);
        
        btnOkList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOkListActionPerformed(evt);
            }
        });
        
        add(JPanelList);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void escolhaAlunoTabela(MouseEvent evt) {
        int linha = tabAlunosList.rowAtPoint(evt.getPoint());
        Aluno aluno = listaAlunos.getAluno(linha);
        saida.imprimirMensagem(aluno.toString());
    }
 
    private void btnOkListActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        dispose();
    }
    private void adicionarDados()
    {
        Aluno aluno;
        for (int i = 0; i < listaAlunos.getQtdAlunos(); i++) {
            aluno = listaAlunos.getAluno(i);
            String dados[] = {aluno.nomeAluno, String.valueOf(aluno.idadeAluno), aluno.rgAluno, aluno.raAluno, aluno.cursoAluno,
                String.valueOf(aluno.semestreAluno), ""};
            for (Disciplina disciplina : aluno.discAluno) {
                dados[6] += disciplina.toTable() +" | ";
            }
            modelList.addRow(dados);
        }
    }
 
}
