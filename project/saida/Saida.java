package saida;
import javax.swing.JOptionPane;

/**
 * Classe Saida
 * 
 * Impressao de mensagens de entrada para tipo grafico. Usa JOptionPane
 */
public class Saida implements ISaida {
    public void imprimirErro(String titulo, String mensagem) { // mensagens tipo warning. Titulo + mensagem
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
    }
    
    public void imprimirMensagem(String mensagem) { // mensagens normais. Sem titulo
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
