//Classe para representar um cliente do banco
package model;
import exceptions.*;

public class Client{
    protected String name;
    protected String email;
    protected String bornedYear; //no formato DD-MM-AAAA
    protected String clientAddress;
    protected String clientPhoneNumber;
    protected String idCard; //codigo do cartao de identificacao do cliente
    private int clientId;
    private static int nextClientId = 1;//permite criar um id unico para cada cliente por default o primeiro obj cliente contem id=1
    protected int age;
    public Account account;

    //Client Constructor
    public Client(){

    }

    public Client(String p_name,String p_email,String p_bornedYear,String p_clientAddress,String p_clientPhoneNumber,String p_idCard,int p_age,Account p_account){
        this.name = p_name;

        Email emailObj = new Email(p_email);
        emailObj.validateEmail(p_email);
        this.email = p_email;

        this.bornedYear = p_bornedYear;
        this.clientAddress = p_clientAddress;

        this.clientPhoneNumber = p_clientPhoneNumber;
        PhoneNumber phoneNumber = new PhoneNumber(p_clientPhoneNumber);
        phoneNumber.validatePhoneNumber(p_clientPhoneNumber);

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

    protected String getClientEmail(){
        if(this.email == null){
            throw new IllegalArgumentException("Erro: o funcionario nao possui um email para retornar!\n");
        }
        return this.email;
    }

    public String getBornedYear(){
        return bornedYear;
    }

    public String getClientAdress(){
        return clientAddress;
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

    public void setClientEmail(String p_email){
        this.email = p_email;
    }

    public void setBornedYear(String p_bornedYear){
        this.bornedYear = p_bornedYear;
    }

    public void setClientAdress(String p_clientAdress){
        this.clientAddress = p_clientAdress;
    }

    public void setClientPhoneNumber(String p_clientPhoneNumber){
        this.clientPhoneNumber = p_clientPhoneNumber;
    }

    public void setClientIDCard(String p_idCard){
        this.idCard = p_idCard;
    }

    public void setClientId(int p_id){
        this.clientId = p_id;
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
        int limMin = 10;
        int limMax = 120;

        if(p_age < 0){
            throw new InvalidAgeException("Erro: parametro invalido passado!\n");
        }

        if(p_age < limMin || p_age > limMax){
            System.out.println("Erro: o valor deve estar entre " +limMin +" e " +limMax +" anos.");
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
        string.append("-ID Cliente: " +client.getClientId() +"\n");
        string.append("-ID Cartao BI: "+client.getClientIDCard() +"\n");
        string.append("-Idade: " +client.getBornedYear() +"\n");

        return string;
    }
}