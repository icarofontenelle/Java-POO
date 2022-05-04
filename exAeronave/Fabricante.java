package exAeronave;

public class Fabricante {
    static private int cont = 0;
    private int idFabricante;
    private String nomeFantasia;
    private String nacionalidade;
    private double precoAcoes;

    public Fabricante (String nomeFantasia, String nacionalidade, double precoAcoes){
        this.idFabricante = ++cont;
        this.nomeFantasia = nomeFantasia;
        this.nacionalidade = nacionalidade;
        this.precoAcoes = precoAcoes;
    }

    public int getIdFabricante() {
        return idFabricante;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public double getPrecoAcoes() {
        return precoAcoes;
    }

    public void atualizarAcoes(double valor){
        precoAcoes = valor;
    }

    @Override
    public String toString() {
        return "Fabricante: " + this.nomeFantasia +"\n";
    }
    
}
