//Enum para representar as classes de cartoes do banco
public enum CardTypes{
    NORMAL("Normal"),EXECUTIVE("Executive"),SPECIAL_I("SpecialI"),SPECIALII("SpecialII"),GOVMEMBER("GovMember");
    private String cardTypes;

    //Enum Constructor
    CardTypes(String p_cardTypes){
        this.cardTypes = p_cardTypes;
    }
}
