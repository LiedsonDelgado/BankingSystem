//Classe de carregamento do Driver da Base de Dados(MySQL em uso no momento,alternativa PosgresSQL)
public class DriverLoader {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso!");
        }catch(ClassNotFoundException error){
            System.out.println("Nao foi possivel carregar o Driver!");
            error.printStackTrace();
        }
    }
}
