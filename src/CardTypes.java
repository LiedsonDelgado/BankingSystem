public enum CardTypes{
    VISA("Visa Internacional"),MASTERCARD("MASTERCARD INTERNACIONAL"),ELO("ELO INTERNACIONAL");

    private final String cardDescrition;

    //Enum CardTypes Constructor
    CardTypes(String p_cardDescrition){
        this.cardDescrition = p_cardDescrition;
    }

    //Methods
    public String getCardDescrition(){
        return cardDescrition;
    }
}
