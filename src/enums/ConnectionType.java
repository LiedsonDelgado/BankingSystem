package enums;

public enum ConnectionType{
    OFFLINE("Offline Connection",0),
    ONLINE("Online Connection",1);

    private final String description;

    //Enum ConnectionType Constuctor
    ConnectionType(String p_description, int p_value){
        this.description = p_description;
    }

    //Methods
    //Getter(s)
    public String getDescription(){
        return description;
    }
}
