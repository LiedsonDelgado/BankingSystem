//Classe para representar um cliente do banco
package model;

public class Client{
    protected String name;
    protected String bornedYear; //no formato DD-MM-AAAA
    protected String clientAdress;
    protected String clientPhoneNumber;
    protected String idCard; //codigo do cartao de identificacao do cliente
    private final int clientId;
    private static int nextClientId = 1;//permite criar um id unico para cada cliente por default o primeiro obj cliente contem id=1
    protected int age;
    public Account account;

    //Client Constructor
    public Client(int p_clientId){
        this.clientId = p_clientId;
    }

    public Client(String p_name,String p_bornedYear,String p_clientAdress,String p_clientPhoneNumber,String p_idCard,int p_age,Account p_account){
        this.name = p_name;
        this.bornedYear = p_bornedYear;
        this.clientAdress = p_clientAdress;
        this.clientPhoneNumber = p_clientPhoneNumber;
        this.idCard = p_idCard;
        this.clientId = nextClientId++;
        this.age = p_age;
        this.account = p_account;
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

    public String getClientPhoneNumber(){
        return clientPhoneNumber;
    }

    public String getClientIDCard(){
        return idCard;
    }

    public int getClientId(){
        return clientId;
    }

    public int getClientAge(){
        return age;
    }

    public Account getAccount(){
        return account;
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

    public void setClientPhoneNumber(String p_clientPhoneNumber){
        this.clientPhoneNumber = p_clientPhoneNumber;
    }

    public void setClientIDCard(String p_idCard){
        this.idCard = p_idCard;
    }

    public void setClientAge(int p_age){
        validateAge(p_age);
        this.age = p_age;
    }

    public void setAccount(Account p_account){
        this.account = p_account;
    }

    //Methods for validation
    //------------------------------------------------------
    public boolean validateAge(int p_age){
        if(p_age < 0){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
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
        string.append("-Contacto: " +client.getClientPhoneNumber() +"\n");
        string.append("ID Cliente: " +client.getClientId() +"\n");
        string.append("-ID Cartao BI: "+client.getClientIDCard() +"\n");
        string.append("Idade: " +client.getBornedYear() +"\n");

        return string;
    }
}