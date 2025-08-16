package enums;

public enum AcessLevel{
    MIDLEVEL("Mid-Level"),SENIOR("Senior-Level"),REGIONAL("Regional-Level");

    public final String description;

    //Enum AcessLevel Constructor
    AcessLevel(String p_description){
        this.description = p_description;
    }

    //Methods
    //Getter(s)
    public String getDescription(){
        return description;
    }
}
