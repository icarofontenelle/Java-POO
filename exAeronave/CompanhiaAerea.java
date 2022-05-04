package exAeronave;

public class CompanhiaAerea {
    static private int cont = 0;
    private int idCompanhia;
    private String nome;

    public CompanhiaAerea(String nome){
        this.idCompanhia= ++cont;
        this.nome = nome;
    }
    
    
    public int getIdCompanhia() {
        return idCompanhia;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "\nCompanhia Aerea: " + nome; 
    }
        
}
