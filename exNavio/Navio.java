package exNavio;

public abstract class Navio{
    private int id;
    private String nome;
    private int qtdPoroes;
    private float capacidadeCarga;
    private String disponibilidade;

    public Navio(int id, String nome, int qtdPoroes, float capacidadeCarga){
        this.id = id;
        this.nome = nome;
        this.qtdPoroes = qtdPoroes;
        this.capacidadeCarga = capacidadeCarga;
        this.disponibilidade = "vazio";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getQtdPoroes() {
        return qtdPoroes;
    }
    
    public void setQtdPoroes(int qtdPoroes) {
        this.qtdPoroes = qtdPoroes;
    }
    
    public float getCapacidadeCarga() {
        return capacidadeCarga;
    }
    
    public void setCapacidadeCarga(float capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
    public String getDisponibilidade() {
        return disponibilidade;
    }
    
    public void iniciaCarregamento(){
        this.disponibilidade = "Disponível";
    }
    public void bloqueiaCarregamento(){
        this.disponibilidade = "Lotado";
    }

    @Override
    public String toString() {
        return ", capacidadeCarga=" + capacidadeCarga + ", disponibilidade=" + disponibilidade + ", id=" + id
                + ", nome=" + nome + ", qtdPoroes=" + qtdPoroes + "]";
    }
    
}