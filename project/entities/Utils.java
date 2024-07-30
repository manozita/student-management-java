package entities;
/**
 * Escreva uma descrição da classe Utils aqui.
 * 
 * @author KLMP
 * @version 14/03
 */
public class Utils {
    /**
     * Método isNumeric - verifica se o valor e numerico
     *
     * @param str para verificar se e numerico
     * @return O nao e numerico
     * @return 1 numero inteiro
     * @return 2 numero decimal
     */
    public static int isNumeric(String str) {
        if (str == null || str.length() == 0) { //string vazia
            return 3;
        }
        
        boolean foundDecimal = false; //variavel booleana que verifica se e decimal
        for (char c : str.toCharArray()) { // percorre a string
            if (!Character.isDigit(c)) { // verifica se e digito
                if (c == '.' && !foundDecimal) { // verifica se existe um unico ponto
                    foundDecimal = true;
                } else { //nao e um numero
                    return 0;
                }
            }
        }            
        if (foundDecimal) //numero decimal positivo, retorna 2
            return 2;
        else //numero inteiro positivo, retorna 1
            return 1;
    }
}
