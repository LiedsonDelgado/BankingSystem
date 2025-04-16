
public class Cartao {

    //por enquanto os campos/variavais de instancia ficam como private podendo ser mudados para public ou protected
    private int numero; //numero do cartao
    private int codigo; //codigo do cartao
    private double saldo; //saldo do cartao pode ser tambem float tanto faz
    private String banco; //nome do banco a qual o cartao pertence
    private String classe; //tipo da classe pertencente ao cartao do banco

    //Card Constructor
    public Cartao(int p_numero, int p_codigo, double p_saldo, String p_banco, String p_classe) { //parametro passados ao construtor da classe
        this.numero = p_numero;
        this.codigo = p_codigo;
        this.saldo = p_saldo;
        this.banco = p_banco;
        this.classe = p_classe;
    }

    //Getters
    public int getNumero() {
        return numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getBanco() {
        return banco;
    }

    public String getClasse() {
        return classe;
    }

    //Setters
    public void getNumero(int s_numero) {
        this.numero = s_numero;
    }

    public void getCodigo(int s_codigo) {
        this.codigo = s_codigo;
    }

    public void getSaldo(double s_saldo) {
        this.saldo = s_saldo;
    }

    public void getBanco(String s_banco) {
        this.banco = s_banco;
    }

    public void getClasse(String s_classe) {
        this.classe = s_classe;
    }
}
