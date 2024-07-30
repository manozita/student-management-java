package persistencia;
/**
 * Escreva a descrição da interface IPersistencia aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface IPersistencia
{
    public void gravarObj(Object objeto, String nomeArq);
    public Object lerObj(String nomeArq);
}
