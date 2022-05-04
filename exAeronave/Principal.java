package exAeronave;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Principal {
    
    static ArrayList <CompanhiaAerea> cAereas = new ArrayList<>();
    static ArrayList <Modelo> modelos = new ArrayList<>();
    static ArrayList <Fabricante> fabricantes = new ArrayList<>();
    static ArrayList  <Aeronave> aeronaves = new ArrayList<>();
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){
    
        int opcao = 0;
        cadastrarFabricante();
        cadastrarModelo();
        cadastrarCompanhiaA();
        do { 
            System.out.println("\n---- Menu ----");
			System.out.println();
			System.out.println("1 - Cadastrar fabricante");
			System.out.println("2 - Cadastrar modelo");
			System.out.println("3 - Cadastrar companhia aerea");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("5 - Informações do Fabricante");
            System.out.println("6 - Manutenção");
			System.out.println("0 - Finalizar");
			
            try {
				System.out.print("\nOpção: ");
				opcao = sc.nextInt();							
			}
			catch (Exception e) {
				System.out.println("A opção deve ser numérica");
				sc.nextLine();
				continue;				
			}
            switch (opcao) {
    		case 1:
                cadastrarFabricante();
                break;
    		case 2:
                cadastrarModelo();
    			break;
    		case 3:
                cadastrarCompanhiaA();
    		    break;
            case 4:
                cadastrarAeronave();
    		    break;
            case 5:
                fabricanteInfo();
                break;
            case 6:
                manutencao();  
                break;    
    		case 0:
				System.out.println("\n ----PROGRAMA FINALIZADO----\n");
				return;
    	    default:
				System.out.println("\n ----Opção inválida----\n");
				break;	
    		}
		}while (true);    
    }
    public static Aeronave verificarId(int idAeronave){
        for(Aeronave aeronave : aeronaves ){            
            if (aeronave.getIdAeronave() == idAeronave){
                return  aeronave;          
            }
        }return null;
    }
    public static void cadastrarFabricante(){
        System.out.print("---- Cadastro Fabricante -----");
        System.out.println();
        System.out.print("Nome: ");
        String nomeFantasia = sc.next();
        
        System.out.print("Nacionalidade: ");
        sc.nextLine();
        String nacionalidade = sc.next();
        
        System.out.print("Preço das ações: R$");
        double precoAcoes = sc.nextDouble();

        Fabricante novoFabricante = new Fabricante(nomeFantasia, nacionalidade, precoAcoes);
        fabricantes.add(novoFabricante);
    }
    public static void cadastrarModelo(){
        System.out.print("---- Cadastro Modelo -----");
        System.out.println();
        for(Fabricante fabricante : fabricantes){
            System.out.print(fabricantes.indexOf(fabricante) + "-Nome: " + fabricante.getNomeFantasia()+"\n");
        }
        System.out.print("\nDigite o número referente ao seu fabricante: ");
        int numFabricante = sc.nextInt();

        Fabricante fAux;
        try {
            fAux = fabricantes.get(numFabricante);
            
        } catch (Exception e) {
            System.out.println("Fabricante não encontrando");
            return;
        }
        
        System.out.print("Sigla: ");
        sc.nextLine();
        String sigla = sc.next();
        
        System.out.print("Capacidade Máxima: ");
        int capacidadeMaxima = sc.nextInt();
        
        System.out.print("Autonomia Voo: ");
        int autonomiaVoo = sc.nextInt();
        
        Modelo novoModelo = new Modelo(sigla, capacidadeMaxima, autonomiaVoo, fAux);
        modelos.add(novoModelo);
    }
    public static void cadastrarCompanhiaA(){
        System.out.print("---- Cadastro Companhia Aérea -----");
        System.out.println();
        System.out.print("Nome da Companhia Aérea: ");
        sc.nextLine();
        String nome = sc.next();

        CompanhiaAerea novaCA = new CompanhiaAerea(nome);
        cAereas.add(novaCA);
    }
    public static void cadastrarAeronave(){
        System.out.print("---- Cadastro Aeronave -----");
        System.out.println();
        System.out.print("\nDigite o ID da aeronave: ");
        int idAeronave = sc.nextInt();
        Aeronave aeronaveExistente = verificarId(idAeronave);
        if(aeronaveExistente != null){
            System.out.print("\nJá possui uma Aeronave com esse ID no sistema!!");
            return;
        }
        for(Modelo modelo : modelos){
            System.out.print(modelos.indexOf(modelo) + "-Sigla: " + modelo.getSigla()+"\n");
        }
        System.out.print("\nDigite o número referente ao modelo da aeronave: ");
        int numModelo = sc.nextInt();
        
        for(CompanhiaAerea cAerea : cAereas){
            System.out.print(cAereas.indexOf(cAerea) + "-Nome: " + cAerea.getNome()+"\n");
        }
        System.out.print("\nDigite o número referente a Companhia Aerea da aeronave: ");
        int numCompanhiaA = sc.nextInt();

        Modelo mAux;
        CompanhiaAerea cAux;
        try {
            mAux = modelos.get(numModelo);
            cAux = cAereas.get(numCompanhiaA);
        } catch (Exception e) {
            System.out.println("Não existente! tente novamente..");
            return;
        }
        System.out.print("Descricao: ");
        sc.nextLine();
        String descricao = sc.next();
        
        System.out.print("Frequencia em meses da manutencao: ");
        int frequenciaManutencao = sc.nextInt();
        
        Aeronave novaAeronave = new Aeronave(idAeronave, descricao, frequenciaManutencao,mAux,cAux);
        aeronaves.add(novaAeronave);
    }
    public static void fabricanteInfo(){
        for(Fabricante fabricante : fabricantes){
            System.out.print(fabricantes.indexOf(fabricante) + "-Nome: " + fabricante.getNomeFantasia()+"\n");
        }
        System.out.println("Qual fabricante deseja analisar?");
        int objetoIndice = sc.nextInt();
        Fabricante fabricanteAux;
        try {
            fabricanteAux = fabricantes.get(objetoIndice);
            System.out.print("\nID: " + fabricanteAux.getIdFabricante());
            System.out.print("\nNome: " + fabricanteAux.getNomeFantasia());
            System.out.print("\nNacinalidade: " + fabricanteAux.getNacionalidade());
            System.out.print("\nPreço Ações: R$" + fabricanteAux.getPrecoAcoes());
        }
        catch(Exception e){
            System.out.println("Nao encontrado");
            return;
        }
        System.out.print("\n\nDeseja atualizar o valor das ações? S/N\n");
        String resposta = sc.next().toUpperCase();
        if(resposta.equals("S")){
            System.out.print("\nNovo valor das Ações: R$");
            double valor = sc.nextDouble();
            fabricanteAux.atualizarAcoes(valor);    
        }
    }
    public static void manutencao(){
        int opcao = 0;
        do{
        System.out.println("\n---- Menu ----");
		System.out.println();
        System.out.println("1- Aeronave Informações");
        System.out.println("2- Colocar uma aeronave em manutenção");
        System.out.println("3- Retirar uma aeronave da manutenção");
        System.out.println("0- Retornar ao menu anterior");
        
        try {
            System.out.print("\nOpção: ");
             opcao = sc.nextInt();							
        }
        catch (Exception e) {
            System.out.println("A opção deve ser numérica");
            sc.nextLine();
            continue;				
        }
        switch (opcao) {
        case 1: 
            for(Aeronave aeronave : aeronaves){
                System.out.print(aeronaves.indexOf(aeronave) + " -ID:" + aeronave.getIdAeronave()+"\n");
            }
            System.out.println("Qual Aeronave deseja analisar?");
            int objetoIndice = sc.nextInt();
            Aeronave aeronaveAux;
            try {
                aeronaveAux = aeronaves.get(objetoIndice); 
                System.out.print("\nID: " + aeronaveAux.getIdAeronave());
                System.out.print("\nDescrição: " + aeronaveAux.getDescricao());
                System.out.print(aeronaveAux.getCompanhiaAerea());
                System.out.print(aeronaveAux.getModelo());
                System.out.print("Última Manutenção: " + aeronaveAux.getDataManutencao());
                System.out.print("\nPróxima Manutenção: " + aeronaveAux.getProximaManutencao() + "\n");   
                }
                catch (Exception e) {
                System.out.println("Não encontrado!!");
                return;
        }break;
        case 2:
            for(Aeronave aeronave : aeronaves){
                if(aeronave.getManutencao()== false){
                System.out.print(aeronaves.indexOf(aeronave) + " -ID:" + aeronave.getIdAeronave()+"\n");
                } 
            }
            System.out.println("Qual aeronave deseja colocar em manutenção?");
            objetoIndice = sc.nextInt();
            try {
                aeronaveAux = aeronaves.get(objetoIndice);
                aeronaveAux.manutencaoEntrada();
                System.out.println("A aeronave " + aeronaveAux.getIdAeronave() +" entrou em manutenção com sucesso.");
            } catch (Exception e) {
                System.out.println("Não encontrado!!");
                return;
        }break;
        case 3:
        for(Aeronave aeronave : aeronaves){
            if(aeronave.getManutencao()== true){
            System.out.print(aeronaves.indexOf(aeronave) + " -ID:" + aeronave.getIdAeronave()+"\n");
            }
        }
        System.out.println("Qual aeronave deseja retirar da manutenção?");
        objetoIndice = sc.nextInt();
        System.out.println("Informe uma data (dd/mm/aaaa): ");
        String dataString = sc.next();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        try {
            aeronaveAux = aeronaves.get(objetoIndice);
            aeronaveAux.manutencaoSaida(data);
            System.out.println("A aeronave " + aeronaveAux.getIdAeronave() +" saiu da manutenção com sucesso.");    
        } catch (Exception e) {
            System.out.println("Não encontrado!!");
            return;
        }break;
        case 0:
            return;
        default:
            System.out.println("\n ----Opção inválida----\n");
        break;
            }
        }while(true);
    }
       
}