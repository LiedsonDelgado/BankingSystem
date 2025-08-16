//Classe principal do Sistema Bancario que executa o sistema via terminal
package app;
import model.*;
import java.util.Scanner;

public class Main{
    public void menu(){
        System.out.println("--MENU DO SISTEMA BANCARIO--");
        System.out.println("1-Adicionar Conta");
        System.out.println("2-Remover Conta");
        System.out.println("3-Adicionar Cliente");
        System.out.println("4-Remover Cliente");
        System.out.println("5-Adicionar Cartao");
        System.out.println("6-Remover Cliente");
        System.out.println("7-Gerar Relatorios");

        System.out.println("0-Sair");
    }

    public static void main(String[] args){
        Main main = new Main();
        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.println("Bem-vindo ao Sistema Bancario & ATM da BCV SERVICES");
        do{
            main.menu();

            System.out.print("Escolha uma opcao: ");
            opc = sc.nextInt();

            switch(opc){
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente!\n");
                    break;
            }
        }while(opc != 0);
    }
}
