package exDev;

public class Desenvolvedor {
    static private int cont = 0;
    private int idDesenvolvedor;
    private String nome;
    private double valorHora;
    private double receitaEmAberto;

    public Desenvolvedor(String nome, double valorHora){
        this.idDesenvolvedor = ++cont;
        this.nome = nome;
        this.valorHora = valorHora;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Desenvolvedor.cont = cont;
    }

    public int getIdDesenvolvedor() {
        return idDesenvolvedor;
    }

    public void setIdDesenvolvedor(int idDesenvolvedor) {
        this.idDesenvolvedor = idDesenvolvedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getReceitaEmAberto() {
        return receitaEmAberto;
    }

    public void setReceitaEmAberto(double receitaEmAberto) {
        this.receitaEmAberto = receitaEmAberto;
    }

    public void creditarFuncionalidade(char tipo, int minutos, double valor){
        switch (tipo) {
            case 'D':
                this.receitaEmAberto += (this.valorHora * minutos/60)+valor*0.2;    
                break;
            case 'C':
                this.receitaEmAberto += (this.valorHora * minutos/60)+valor;
                break;
            case 'A':
                this.receitaEmAberto += (this.valorHora * minutos/60)+valor*0.1;
                break;
            }
        }
    public boolean debitarPagamento(double valor){
        if (this.receitaEmAberto < valor){
            return false;
        }else{
            this.receitaEmAberto = this.receitaEmAberto - valor;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Desenvolvedor: \nidDesenvolvedor= " + idDesenvolvedor + 
        "\nnome= " + nome + "\nvalorHora= " + valorHora;
    }
    
}

