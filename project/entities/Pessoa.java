package entities;

/**
 * Escreva uma descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pessoa implements java.io.Serializable
{
    private NomePessoa nome;
    int idade;
    String rg;
    
    public Pessoa (String nome, int idade, String rg) { //
        this.nome = new NomePessoa(nome);
        this.idade = idade;
        this.rg = rg;
        
    }
}
