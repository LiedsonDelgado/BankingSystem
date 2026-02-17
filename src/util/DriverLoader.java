//Classe de carregamento do Driver da Base de Dados(MySQL em uso no momento,alternativa PosgresSQL)
package util;

public class DriverLoader {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso!");
        }catch(ClassNotFoundException cne){
            System.out.println("Nao foi possivel carregar o Driver!");
            cne.printStackTrace();
        }
    }
}
