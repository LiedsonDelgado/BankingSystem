//Classe para representar um atm e suas funcoes/propriedades
public class ATM implements InterfaceATM{
  private Bank bank; //qual banco o ATM esta associado
  private int pin;

  public ATM(Bank p_bank){
    this.bank = p_bank;
  }

  public void realizarOperacoes(){
    
  }
}
