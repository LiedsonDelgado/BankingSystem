package enums;

public enum ATMStatus{
    INATIVO("Inativo",0),
    ACTIVO("Activo",1),
    MANUTENCAO("Manutencao",2);

    private final String description;

    //Enum ATM Status Constructor
    ATMStatus(String p_description,int p_value){
        this.description = p_description;
    }

    //Methods
    //Getter(s)
    public String getDescription(){
        return description;
    }
}
