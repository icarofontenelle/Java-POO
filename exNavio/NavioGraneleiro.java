package exNavio;

public class NavioGraneleiro extends Navio{
    private int qtdEscotilhas;

    

    public NavioGraneleiro(int id, String nome, int qtdPoroes, float capacidadeCarga, int qtdEscotilhas) {
        super(id, nome, qtdPoroes, capacidadeCarga);
        this.qtdEscotilhas = qtdEscotilhas;
    }

    public int getQtdEscotilhas() {
        return qtdEscotilhas;
    }

    @Override
    public String toString() {
        return "[qtdEscotilhas=" + qtdEscotilhas + super.toString();
    }

    
}