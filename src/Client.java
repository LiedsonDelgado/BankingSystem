//Classe para representar um cliente do banco
public class Client{
    protected String name;
    protected String bornedYear; //no formato DD-MM-AAAA
    protected String clientAdress;
    protected String idCard; //codigo do cartao de identificacao do cliente
    private final int clienId;
    private static int newClientId = 1;//permite criar um id unico para cada cliente por default o primeiro obj cliente contem id=1
    protected int age;

    //Client Constructor
    public Client(String p_name,String p_bornedYear,String p_clientAdress,String p_idCard,int p_age){
        this.name = p_name;
        this.bornedYear = p_bornedYear;
        this.clientAdress = p_clientAdress;
        this.idCard = p_idCard;
        this.clienId = newClientId++;
        this.age = p_age;
    }

    //Methods
    //Getters
    public String getClientName(){
        return name;
    }

    public String getBornedYear(){
        return bornedYear;
    }

    public String getClientAdress(){
        return clientAdress;
    }

    public String getClientIDCard(){
        return idCard;
    }

    public int getClientId(){
        return clienId;
    }

    public int getClientAge(){
        return age;
    }

    //Setters
    public void setClientName(String p_name){
        this.name = p_name;
    }

    public void setBornedYear(String p_bornedYear){
        this.bornedYear = p_bornedYear;
    }

    public void setClientAdress(String p_clientAdress){
        this.clientAdress = p_clientAdress;
    }

    public void setClientIDCard(String p_idCard){
        this.idCard = p_idCard;
    }

    public void setClientAge(int p_age){
        this.age = p_age;
    }

    //Methods for validation
    //------------------------------------------------------
    public boolean validateAge(int p_age){
        if(p_age < 0){
            throw new IllegalArgumentException("Erro: valor invalido!");
        }

        if(p_age < 10 || p_age > 130){
            System.out.println("Erro: o valor deve estar entre 10 e 130 anos.");
            return false;
        }
        return true;
    }
    //------------------------------------------------------

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public StringBuilder showClientInfo(Client client){
        StringBuilder string = new StringBuilder();

        string.append("-Nome: " +client.getClientName() +"\n");
        string.append("-Data de Nascimento: " +client.getBornedYear() +"\n");
        string.append("-Endereco: " +client.getClientAdress() +"\n");
        string.append("ID do Cliente: " +client.getClientId() +"\n");
        string.append("-ID do Cartao BI: "+client.getClientIDCard() +"\n");
        string.append("Idade: " +client.getBornedYear() +"\n");

        return string;
    }
}