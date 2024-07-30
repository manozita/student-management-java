package entities;

/**
 * Classe disciplina
 * 
 * Dsciplina para os alunos
 */
public class Disciplina implements java.io.Serializable
{
    // atributos, variaveis de instancia
    String codigoDisc;
    Texto nomeDisc;
    float mediaDisc;
    
    /**
     * Disciplina Construtor: cria a nova disciplina com os valores de entrada de outra classe
     *
     * @param codigo da disciplina
     * @param nome da disciplina
     * @param media da disciplina
     */
    public Disciplina (String codigo, String nome, float media) {
        codigoDisc = codigo;
        nomeDisc = new Texto(nome);
        mediaDisc = media;
    }
    
    public String toString () { // impressao de dados
        String s = "\n      " + this.nomeDisc + "(" + this.codigoDisc + ") = nota " + this.mediaDisc;
        return s;
    }
    
    public String toTable() {
        String s = this.codigoDisc;
        return s;
    }
}
