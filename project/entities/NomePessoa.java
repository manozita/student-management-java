package entities;

/**
 * Escreva uma descrição da classe NomePessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class NomePessoa implements java.io.Serializable
{
    // instancias de entrada
    Texto nome;
    
    // construtor
    NomePessoa(String nome) {
        this.nome = new Texto(nome);
    }
    
    // funcoes
    String inverterNome() {
        return nome.inverterTexto();
    }
    
    int qtdPalavras() {
        return nome.getQtdePalavras();
    }
    
    public String getNomeBibliografico() {
        // entrada
        int i, limite; String nomeBibliografico;
        String[] nomeCompleto = nome.getTxt().split(" "); // divide nomes na lista de string
        limite = (nomeCompleto.length - 1); // define limite da busca de nomes
        
        nomeBibliografico = nomeCompleto[limite] + ","; // ultimo sobrenome completo, separado por virgula
        for (i = 0; i < limite; i++) {
            if (!nomeCompleto[i].toLowerCase().matches("da|de|di|do|das|dos|e")) { // verifica se nenhum dos sobrenomes eh um dos mencionados
                nomeBibliografico += " " + nomeCompleto[i].charAt(0) + "."; // inicial dos nomes restantes, separados por ponto
            }
        }
        return nomeBibliografico;
    }
}
