package exDev;

public class Funcionalidade {
    static private int cont = 0;
    private int idFuncionalidade;
    private String descricao;
    private int minutosParaImplementar;
    private double valor;
    private char tipo;
    private char status;
    private Desenvolvedor desenvolvedor;
    
    public Funcionalidade(String descricao, int minutosParaImplementar, double valor, char tipo) {
        this.idFuncionalidade = ++cont;
        this.descricao = descricao;
        this.minutosParaImplementar = minutosParaImplementar;
        this.valor = valor;
        this.tipo = tipo;
        this.status =  'P';
    }

    public int getIdFuncionalidade() {
        return idFuncionalidade;
    }

    public void setIdFuncionalidade(int idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMinutosParaImplementar() {
        return minutosParaImplementar;
    }

    public void setMinutosParaImplementar(int minutosParaImplementar) {
        this.minutosParaImplementar = minutosParaImplementar;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public void atribuirFuncionalidade(Desenvolvedor dev){
        this.desenvolvedor = dev;
        this.status = 'D';
    }
    
    public void registrarConclusao(){
        this.status = 'C';
        this.desenvolvedor.creditarFuncionalidade(this.tipo, this.minutosParaImplementar, this.valor);
    }

    @Override
    public String toString() {
        return "Funcionalidade: \ndescricao= " + descricao + 
        "\ndesenvolvedor= " + desenvolvedor + ",\nidFuncionalidade= "+ idFuncionalidade;
    }

    
    
}
