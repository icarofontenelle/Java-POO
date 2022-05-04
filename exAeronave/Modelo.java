package exAeronave;

public class Modelo {
    static private int cont = 0;
    private int idModelo;
    private String sigla;
    private int capacidadeMaxima;
    private int autonomiaVoo;
    private Fabricante fabricante;

    public Modelo(String sigla, int capacidadeMaxima, int autonomiaVoo, Fabricante fabricante){
        this.idModelo = ++cont;
        this.sigla = sigla;
        this.capacidadeMaxima = capacidadeMaxima;
        this.autonomiaVoo = autonomiaVoo;
        this.fabricante = fabricante;
    }

    public String getSigla() {
        return sigla;
    }
    
    @Override
    public String toString() {
        return "\n Modelo: " + this.sigla + "\n";
    }

    
    
    
    
}
