package cadastro;
import persistencia.*;
import GUI.*;
import entities.*;
import saida.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Lista aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ListaArray implements IArmazenador {

    // variáveis de instância
    IPersistencia arqBin = new ArquivoBinario();
    private ArrayList<Aluno> armazenador; // armazenador de alunos
    ISaida saida = new Saida(); // para saidas em modo grafico
    Aluno temp = new Aluno("", 0, "", null, "", 0, null); // instancia temporaria de aluno para acessar o metodo buscarAluno[
    ListagemGUI listagem;
  
    /**
     * Construtor para objetos da classe CadastroAlunos
     */
    public ListaArray() {
        // inicializa variáveis de instância
        armazenador = new ArrayList<Aluno>();
    }
    /**
     * Método buscar
     *
     * @param "a" para o aluno criado
     * retorna true se a inserção foi bem sucedida. 
     * retorna false se foi mal sucedida.
     */
    public boolean buscar(String ra){
        for (Aluno aluno : armazenador) {
            if (aluno.raAluno.equals(ra)) return true;
        }
        return false;
    }
    /**
     * Método verificarVazia
     *
     * retorna true se nao ha alunos no array
     * retorna false se pelo menos um aluno estiver presente no array
     */
    public boolean verificarVazia(){
        return armazenador.isEmpty();
    }
    /**
     * Método inserir
     *
     * @param "a" para o aluno criado
     * retorna true se a insercao foi bem sucedida
     * retorna false se nao ha espaco para o aluno
     */
    public boolean inserir(Aluno a){
        armazenador.add(a);
        return true;
    }
    /**
     * Método remover
     * 
     * @param "ra" para o ra do aluno a ser removido
     * retorna true se a remocao foi bem sucedida. 
     * retorna false se foi mal sucedida.
     */
    public boolean remover(String ra){
        for (Aluno aluno : armazenador) {
            if (aluno.raAluno.equals(ra)) {
                armazenador.remove(aluno);
                return true;
            }
        }
        return false;
    }
    /**
     * Método listar
     *
     * lista os alunos
     */
    public void listar(){
        if (verificarVazia())
            saida.imprimirErro("LISTAR","A lista esta vazia.");
        else {
            listagem = new ListagemGUI(this);
            listagem.setVisible(true);
        }
    }
    
    public boolean ler(String nomeArq) {
        try {
            FileInputStream fileIn = new FileInputStream(nomeArq);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int qtd = objectIn.readInt();
            for (int i = 0; i < qtd; i++) {
                Aluno aluno = (Aluno) objectIn.readObject();
                armazenador.add(aluno);
            }
            objectIn.close(); fileIn.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }
    
    public boolean armazenar(String nomeArq) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArq);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeInt(armazenador.size());
            for (Aluno aluno : armazenador) {
                objectOut.writeObject(aluno);
            }
            objectOut.close(); fileOut.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public Aluno getAluno(int i) {
        Aluno aluno = armazenador.get(i);
        return aluno;
    }
    
    public int getQtdAlunos() {
        return armazenador.size();
    }
}

