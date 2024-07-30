package app;
import GUI.*;
import entrada.*;
import saida.*;
import entities.*;
/**
* Classe principal de aplicacao e teste
* 
* Manoela Martedi, Luan Capella, Kaua Cordeiro
* versao 14/05
*/
public class Aplicacao
{
    public MenuGUI menuPrincipal; // menu principal JPane
    
    public Aplicacao() {
        menuPrincipal = new MenuGUI();
        menuPrincipal.setVisible(true);
    }
    
    public static void main (String[] args) {
        Aplicacao app = new Aplicacao();
    }

}