package exNavio;

public class NavioContainer extends Navio {
    private int quantidadeGuindastes;
    private int quantidadeCamadas;
    
    

    public NavioContainer(int id, String nome, int qtdPoroes, float capacidadeCarga, int quantidadeGuindastes,
                          int quantidadeCamadas) {
        super(id, nome, qtdPoroes, capacidadeCarga);
        this.quantidadeGuindastes = quantidadeGuindastes;
        this.quantidadeCamadas = quantidadeCamadas;
    }

    public int getQuantidadeGuindastes() {
        return quantidadeGuindastes;
    }

    public int getQuantidadeCamadas() {
        return quantidadeCamadas;
    }

    @Override
    public String toString() {
        return "[quantidadeCamadas=" + quantidadeCamadas + ", quantidadeGuindastes="
                + quantidadeGuindastes + super.toString();
    }
    

}
