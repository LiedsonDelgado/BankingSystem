//Classe principal do Sistema Bancario que executa o sistema via terminal
package app;
import model.*;
import java.util.*;

public class Main{
    public void menu(){
        System.out.println("\n--MENU DO SISTEMA BANCARIO--");
        System.out.println("1-Adicionar conta");
        System.out.println("2-Remover conta");
        System.out.println("3-Adicionar cliente");
        System.out.println("4-Remover cliente");
        System.out.println("5-Adicionar cartao");
        System.out.println("6-Remover cartao");
        System.out.println("7-Adicionar operario");
        System.out.println("8-Remover operario");
        System.out.println("9-Gerar relatorios");

        System.out.println("0-Sair");
    }

    public void subMenu1(){
        System.out.println("\n--Funcionarios--");
        System.out.println("1-Gerente");
        System.out.println("2-Membro de equipe");
        System.out.println("3-Funcionario comum");
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String bankName;
        String bankAdress;
        int bankCode = 0;
        int opc;

        System.out.print("Nome do banco: ");
        bankName = sc.nextLine();

        System.out.print("Endereco do banco: ");
        bankAdress = sc.nextLine();

        System.out.print("Codigo do banco: ");
        sc.nextInt();

        Bank bcv = new Bank(bankName,bankAdress,bankCode);

        System.out.println("Bem-vindo ao Sistema Bancario & ATM da " +bankName);
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

                case 8:
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente!\n");
                    break;
            }
        }while(opc != 0);
    }
}
