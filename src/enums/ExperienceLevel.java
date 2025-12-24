package enums;

public enum ExperienceLevel {
    JUNIORLEVEL("Junior-Level"),
    MIDLEVEL("Mid-Level"),
    SENIOR("Senior-Level");

    public final String description;

    //Enum AcessLevel Constructor
    ExperienceLevel(String p_description){
        this.description = p_description;
    }

    //Methods
    //Getter(s)
    public String getDescription(){
        return description;
    }
}
