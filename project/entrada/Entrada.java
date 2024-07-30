package entrada;
import javax.swing.JOptionPane;

public class Entrada implements IEntrada {
    public String imprimirInput(String mensagem) {
        String ans = JOptionPane.showInputDialog(mensagem);
        return ans;
    }
    
    public int imprimirPergunta(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem);
    }
}
