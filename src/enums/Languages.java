package enums;

public enum Languages{
    PTPT("Portugues-Portugal"),
    PTBR("Portugues-Brasil"),
    EN("Ingles"),
    ES("Espanhol"),
    FR("Frances"),
    RU("Russo");

    private final String description;

    //Enum Languages Constructor
    Languages(String p_description){
        this.description =  p_description;
    }

    //Methods
    //Getter(s)
    public String getDescription(){
        return description;
    }
}
