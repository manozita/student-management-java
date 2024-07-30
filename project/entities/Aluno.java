package entities;

/**
 * Classe Aluno
 * 
 * Alunos
 */
public class Aluno extends Pessoa implements java.io.Serializable
{
    // atributos
    public String raAluno, cursoAluno, nomeAluno, rgAluno;
    public int semestreAluno, idadeAluno;
    public Disciplina discAluno[];
    
    public Aluno (String nome, int idade, String rg, String ra, String curso, int semestre, Disciplina disciplinas[]) {
        super(nome, idade, rg); // super aciona o construtor da classe pai, no caso, Pessoa
        
        // dados do aluno
        nomeAluno = nome;
        idadeAluno = idade;
        rgAluno = rg;
        raAluno = ra;
        cursoAluno = curso;
        semestreAluno = semestre;
        discAluno = disciplinas;
    }
    
    public String toString(){
        String s = "--------------------- " + nomeAluno + " ---------------------\n" +
                    "\nIdade: " + idadeAluno +
                    "\nRg: " + rgAluno +
                    "\nRa: " + raAluno +
                    "\nCurso: " + cursoAluno +
                    "\nSemestre: " + semestreAluno;
        if (discAluno.length != 0) {
            s += "\nDisciplinas: ";
            for (int i = 0; i < discAluno.length; i++) {
                s += discAluno[i].toString();
            }
        }
        return s;
    }
}
