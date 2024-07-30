package cadastro;
import app.*;
import entities.*;
/**
 * IArmazenador interface para armazenadores.
 * 
 * @author Julio Arakaki 
 * @version 12/04/2023
 */

public interface IArmazenador { 
    public boolean inserir(Aluno a);
    public boolean remover(String ra);
    public boolean verificarVazia();
    public boolean buscar (String ra);
    public Aluno getAluno(int i);
    public int getQtdAlunos();
    public void listar();
    public boolean ler(String nomeArq);
    public boolean armazenar(String nomeArq);
}

