package exDev;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    static ArrayList <Desenvolvedor> Desenvolvedores = new ArrayList<>();
    static ArrayList <Funcionalidade> Funcionalidades = new ArrayList<>();
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int opcao = 0;

        do { 
            System.out.println("\n---- Menu ----");
			System.out.println();
			System.out.println("1 - Cadastrar desenvolvedor");
			System.out.println("2 - Cadastrar funcionalidade");
			System.out.println("3 - Atribuir desenvolvedor");
            System.out.println("4 - Registrar conclusão");
            System.out.println("5 - Registrar pagamento");
            System.out.println("6 - Mostrar funcionalidade");
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
            cadastrarDesenvolvedor();
            break;
        case 2:
            cadastrarFuncionalidade();
            break;
        case 3:
            atribuirDesenvolvedor();
            break;
        case 4:
            registrarConclusao();
            break;
        case 5:
            registrarPagamento();
            break;
        case 6:
            mostrarFuncionalidade();
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
    public static void cadastrarDesenvolvedor(){
        System.out.print("---- Cadastro Desenvolvedor -----");
        System.out.println();
        System.out.print("Nome: ");
        String nomeDesenvolvedor = sc.next();
        double valorHora = 0;
        do{
            try{
                System.out.print("Valor/Hora:R$ ");
                valorHora = sc.nextDouble();         
            }
            catch (Exception e) {
				System.out.println("Valor inválido!");
				sc.nextLine();
				continue;
            }
            break;
        }while(true);
        Desenvolvedor novoDesenvolvedor = new Desenvolvedor(nomeDesenvolvedor, valorHora);
        Desenvolvedores.add(novoDesenvolvedor);
    }
    public static void cadastrarFuncionalidade(){
        System.out.print("---- Cadastro Funcionalidade -----");
        System.out.println();
        System.out.println("Descrição: ");
        String descricao = sc.next();
        sc.nextLine();
        System.out.println("Minutos: ");
        int minutos = sc.nextInt();
        System.out.println("Valor: ");
        double valor = sc.nextDouble();
        char tipo=' ';
        do {
            sc.nextLine();
            System.out.println("Tipo (d/c/a): ");
            tipo = sc.nextLine().charAt(0);
            tipo = Character.toLowerCase(tipo);
            if (!(tipo == 'd'|| tipo == 'c' || tipo == 'a')){
               System.out.println("tipo inválido.");
               continue;
            }
            break;
        }while(true);
        
        Funcionalidade novaFuncionalidade = new Funcionalidade(descricao, minutos, valor, tipo);
        Funcionalidades.add(novaFuncionalidade);
    }
    public static void atribuirDesenvolvedor(){
        for(Desenvolvedor desenvolvedor : Desenvolvedores){
            System.out.print(Desenvolvedores.indexOf(desenvolvedor) + "-Nome: " + desenvolvedor.getNome()+"\n");
        }
        System.out.print("\nDigite o número referente ao seu desenvolvedor: ");
        int numDesenvolvedor = sc.nextInt();
        
        Desenvolvedor dAux;    
        try {
            dAux = Desenvolvedores.get(numDesenvolvedor);
            
        } catch (Exception e) {
            System.out.println("Desenvolvedor não encontrado.");
            return;
        }

        for(Funcionalidade funcionalidade : Funcionalidades){
            System.out.print(Funcionalidades.indexOf(funcionalidade) + "-id: " + funcionalidade.getIdFuncionalidade()+"\n");
        }
        System.out.print("\nDigite o número referente a sua funcionalidade: ");
        int numFuncionalidade = sc.nextInt();

        Funcionalidade fAux;
        try {
            fAux = Funcionalidades.get(numFuncionalidade);
            
        } catch (Exception e) {
            System.out.println("Funcionalidade não encontrada.");
            return;
        }
        fAux.atribuirFuncionalidade(dAux);
    }
    public static void registrarConclusao(){
        for(Funcionalidade funcionalidade : Funcionalidades){
            System.out.print(Funcionalidades.indexOf(funcionalidade) + "-id: " + funcionalidade.getIdFuncionalidade()+"\n");
        }
        System.out.print("\nDigite o número referente a sua funcionalidade: ");
        int numFuncionalidade = sc.nextInt();

        Funcionalidade fAux;
        try {
            fAux = Funcionalidades.get(numFuncionalidade);
            
        } catch (Exception e) {
            System.out.println("Funcionalidade não encontrada.");
            return;
        }
        fAux.registrarConclusao();
    }
    public static void registrarPagamento(){
        for(Desenvolvedor desenvolvedor : Desenvolvedores){
            System.out.print(Desenvolvedores.indexOf(desenvolvedor) + "-Nome: " + desenvolvedor.getNome()+"\n");
        }
        System.out.print("\nDigite o número referente ao seu desenvolvedor: ");
        int numDesenvolvedor = sc.nextInt();
        
        Desenvolvedor dAux;    
        try {
            dAux = Desenvolvedores.get(numDesenvolvedor);
            
        } catch (Exception e) {
            System.out.println("Desenvolvedor não encontrado.");
            return;
        }

        System.out.println("digite o valor do pagamento: ");
        double pagamento = sc.nextDouble();
        dAux.debitarPagamento(pagamento);
    }
    public static void mostrarFuncionalidade(){
        for(Funcionalidade funcionalidade : Funcionalidades){
            System.out.print(Funcionalidades.indexOf(funcionalidade) + "-id: " + funcionalidade.getIdFuncionalidade()+"\n");
        }
        System.out.print("\nDigite o número referente a sua funcionalidade: ");
        int numFuncionalidade = sc.nextInt();

        Funcionalidade fAux;
        try {
            fAux = Funcionalidades.get(numFuncionalidade);
            
        } catch (Exception e) {
            System.out.println("Funcionalidade não encontrada.");
            return;
        }
        System.out.println(fAux.toString());
    }
}


