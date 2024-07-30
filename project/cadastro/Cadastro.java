package cadastro;
import GUI.*;
import entities.*;
import entrada.*;
import saida.*;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Escreva uma descrição da classe Cadastro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cadastro
{
    // instancias
    //IArmazenador listaCadastro = new VetDin(); // usa vetor dinamico no armazenador
    IArmazenador listaCadastro = new ListaArray(); // usa lista de arrays no armazenador
    public CadastroGUI menuCadastro = new CadastroGUI(this); // menu para o cadastro JPane
    
    ISaida saida = new Saida(); // para saidas em modo grafico
    IEntrada entrada = new Entrada(); // para entradas em JOptionPane
    
    private JFileChooser escolherArquivo;

    public Cadastro() {
        escolherArquivo = new JFileChooser();
        escolherArquivo.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Serialized Objects", "ser"));
    }
    
    public void inserirAluno(Aluno aluno) {
        String RAAluno;
        RAAluno = menuCadastro.getRA();
        if (listaCadastro.buscar(RAAluno))
            saida.imprimirErro("FALHA NA INSERCAO", "RA ja presente na lista de alunos.");
        else if (listaCadastro.inserir(aluno)) // se a insercao for bem sucedida
            saida.imprimirMensagem("Aluno inserido com sucesso.");
        else // sem espaco no array
            saida.imprimirErro("FALHA NA INSERCAO","Não ha espaço para inserir o aluno.");
    }
    
    public void removerAluno() {
        String RA = entrada.imprimirInput("RA do aluno a ser removido: ");
        if (RA != null && !RA.isEmpty()) {
            if (listaCadastro.remover(RA))
                saida.imprimirMensagem("Aluno removido com sucesso.");
            else
                saida.imprimirErro("FALHA NA INSERCAO","Aluno nao esta na lista.");
        }
    }
    
    public void listarAluno() {
        listaCadastro.listar();
    }
    
    public void lerArquivo() {
        int option = escolherArquivo.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = escolherArquivo.getSelectedFile();
            if (listaCadastro.ler(file.getPath())) {
                saida.imprimirMensagem("Arquivo lido com sucesso.");
            } else {
                saida.imprimirErro("FALHA NA LEITURA", "Erro no arquivo.");
            }
        }
    }
    
    public void salvarProgresso() {
        int opcao = escolherArquivo.showSaveDialog(null);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = escolherArquivo.getSelectedFile();
            if (!arquivo.getPath().endsWith(".ser")) {
                arquivo = new File(arquivo.getPath() + ".ser");
            }
            
            if (listaCadastro.armazenar(arquivo.getPath())) {
                saida.imprimirMensagem("Progresso salvo com sucesso.\nArquivo " + arquivo.getPath());
            } else {
                saida.imprimirErro("FALHA NA LEITURA", "Erro ao salvar o progresso.");
            }
        }
    }

}
