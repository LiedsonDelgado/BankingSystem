
import java.time.LocalDate;
import java.util.ArrayList;

public class Banco {

    private LocalDate dataCriacao; //pode ser passado usando o LocalDate.now() ou LocalDate.of(year,month,day)
    private String nome;
    private int codigoBanco;
    private ArrayList<Cartao> cartoesEmitidos;

    //Construtor Banco
    public Banco(LocalDate p_data, String p_nome, int p_codigo) {
        this.dataCriacao = p_data;
        this.nome = p_nome;
        this.codigoBanco = p_codigo;

        this.cartoesEmitidos = new ArrayList<>();
    }
}
