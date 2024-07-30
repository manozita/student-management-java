package cadastro;
import persistencia.*;
import GUI.*;
import entities.*;
import saida.*;
import java.io.*;

/**
 * VetDin simula um array dinâmico específico para objetos do tipo Aluno.
 * 
 * @version 12/04/2023
 */
public class VetDin implements IArmazenador {

    // Atributos
    private Aluno[] armazenador; // array para armazenar alunos
    private int qtd; // quantidade de alunos no array
    ISaida saida = new Saida(); // para saídas em modo gráfico
    ListagemGUI listagem;

    /**
     * Construtor - inicia um array e seta a quantidade
     */
    public VetDin() {
        this.armazenador = new Aluno[1]; // inicializa o array com tamanho 1
        this.qtd = 0; // inicializa a quantidade de alunos como 0
    }

    /**
     * Método inserir
     * 
     * @param a o aluno a ser inserido
     * @return true se a inserção foi bem-sucedida
     */
    @Override
    public boolean inserir(Aluno a) {
        if (qtd == armazenador.length) { // se o array está cheio, redimensiona
            Aluno[] novoArray = new Aluno[armazenador.length * 2]; // cria um novo array com o dobro do tamanho
            copiar(armazenador, novoArray); // copia os elementos do array antigo para o novo
            armazenador = novoArray; // atualiza o array
        }
        armazenador[qtd] = a; // insere o novo aluno
        qtd++; // incrementa a quantidade de alunos
        return true; // retorna sucesso
    }

    /**
     * Método remover
     * 
     * @param ra o RA do aluno a ser removido
     * @return true se a remoção foi bem-sucedida
     */
    @Override
    public boolean remover(String ra) {
        for (int i = 0; i < qtd; i++) {
            if (armazenador[i].raAluno.equals(ra)) {
                armazenador[i] = null; // define o aluno como null
                // Cria vetor auxiliar com menos um elemento
                Aluno[] aux = new Aluno[qtd - 1];
                copiar(armazenador, aux); // copia os elementos restantes para o vetor auxiliar
                armazenador = aux; // atualiza o array
                qtd--; // decrementa a quantidade de alunos
                return true; // retorna sucesso
            }
        }
        return false; // retorna falha se o aluno não foi encontrado
    }

    /**
     * Método verificarVazia
     * 
     * @return true se não há alunos no array
     */
    @Override
    public boolean verificarVazia() {
        return qtd == 0; // retorna true se a quantidade de alunos for 0
    }

    /**
     * Método buscar
     * 
     * @param ra o RA do aluno a ser buscado
     * @return true se o aluno for encontrado
     */
    @Override
    public boolean buscar(String ra) {
        for (int i = 0; i < qtd; i++) {
            if (armazenador[i] != null && armazenador[i].raAluno.equals(ra)) {
                return true; // retorna true se o aluno for encontrado
            }
        }
        return false; // retorna false se o aluno não for encontrado
    }

    /**
     * Método getAluno
     * 
     * @param i o índice do aluno no array
     * @return o aluno na posição i, ou null se o índice for inválido
     */
    @Override
    public Aluno getAluno(int i) {
        if (i >= 0 && i < qtd) {
            return armazenador[i]; // retorna o aluno na posição i
        }
        return null; // retorna null se o índice for inválido
    }

    /**
     * Método getQtdAlunos
     * 
     * @return a quantidade de alunos no array
     */
    @Override
    public int getQtdAlunos() {
        return qtd; // retorna a quantidade de alunos
    }

    /**
     * Método listar
     * 
     * lista os alunos
     */
    @Override
    public void listar() {
        if (verificarVazia()) {
            saida.imprimirErro("LISTAR", "A lista está vazia."); // imprime mensagem de erro se a lista estiver vazia
        } else {
            listagem = new ListagemGUI(this);
            listagem.setVisible(true); // exibe a GUI de listagem
        }
    }

    /**
     * Método armazenar
     * 
     * @param arquivo o nome do arquivo onde os dados serão armazenados
     * @return true se o armazenamento foi bem-sucedido
     */
    public boolean armazenar(String arquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(arquivo); // cria um FileOutputStream
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // cria um ObjectOutputStream
            objectOut.writeInt(qtd); // escreve a quantidade de alunos no arquivo
            for (int i = 0; i < qtd; i++) {
                objectOut.writeObject(armazenador[i]); // escreve cada aluno individualmente no arquivo
            }
            objectOut.close();
            fileOut.close();
            return true; // retorna sucesso
        } catch (IOException e) {
            return false; // retorna falha em caso de exceção
        }
    }

    /**
     * Método ler
     * 
     * @param arquivo o nome do arquivo de onde os dados serão lidos
     * @return true se a leitura foi bem-sucedida
     */
    @Override
    public boolean ler(String arquivo) {
        try {
            FileInputStream fileIn = new FileInputStream(arquivo); // cria um FileInputStream
            ObjectInputStream objectIn = new ObjectInputStream(fileIn); // cria um ObjectInputStream
            int qtd = objectIn.readInt(); // lê a quantidade de alunos do arquivo
            if (armazenador.length < qtd) { // redimensiona o array se necessário
                Aluno[] novoArray = new Aluno[qtd];
                copiar(armazenador, novoArray);
                armazenador = novoArray;
            }
            for (int i = 0; i < qtd; i++) {
                Aluno aluno = (Aluno) objectIn.readObject(); // lê cada aluno individualmente do arquivo
                armazenador[i] = aluno;
            }
            this.qtd = qtd;
            objectIn.close();
            fileIn.close();
            return true; // retorna sucesso
        } catch (IOException | ClassNotFoundException e) {
            return false; // retorna falha em caso de exceção
        }
    }

    /**
     * Método copiar
     * 
     * @param origem o array de origem
     * @param destino o array de destino
     * copia os elementos não-nulos do array de origem para o array de destino
     */
    private void copiar(Aluno[] origem, Aluno[] destino) {
        int k = 0;
        for (int i = 0; i < origem.length; i++) {
            if (origem[i] != null) {
                destino[k] = origem[i];
                k++;
            }
        }
    }
}
