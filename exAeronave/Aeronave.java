package exAeronave;

import java.time.LocalDate;

public class Aeronave {
    private int idAeronave;
    private String descricao;
    private LocalDate dataManutencao;
    private LocalDate proximaManutencao;
    private int frequenciaManutencao;
    private boolean manutencao;
    private Modelo modelo;
    private CompanhiaAerea companhiaAerea;
    
    public Aeronave(int idAeronave, String descricao,int frequenciaManutencao, Modelo modelo, CompanhiaAerea companhiaAerea){
        this.idAeronave = idAeronave;
        this.descricao = descricao;
        this.manutencao = false;
        this.modelo = modelo;
        this.companhiaAerea = companhiaAerea;
        this.frequenciaManutencao = frequenciaManutencao;
                }

    public int getIdAeronave() {
        return idAeronave;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public LocalDate getProximaManutencao() {
        return proximaManutencao;
    }

    public boolean getManutencao() {
        return manutencao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    public int getFrequenciaManutencao() {
        return frequenciaManutencao;
    }
    
    public void manutencaoEntrada(){
        this.manutencao = true;
    }
    
    public void manutencaoSaida(LocalDate data){
        this.manutencao = false;
        this.dataManutencao = data;
        this.proximaManutencao = this.dataManutencao.plusMonths(this.frequenciaManutencao);
    }   
        
}