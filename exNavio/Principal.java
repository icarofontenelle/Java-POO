package exNavio;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){
        ArrayList <NavioContainer> nc  = new ArrayList<>();
        ArrayList <NavioGraneleiro> ng = new ArrayList<>();

         nc.add(new NavioContainer(33, "Bela Fera", 2, 100000, 2, 30));
         nc.add(new NavioContainer(48, "Arrecifes", 2, 120000, 2, 30));
         nc.add(new NavioContainer(52, "Águas Belas", 1, 90000, 0, 25));

         ng.add(new NavioGraneleiro(10, "Estrela do Mar", 4, 50000, 4));

         ng.add(new NavioGraneleiro(25, "Cruzeiro do Sul", 3, 80000, 6));

         for(NavioContainer naviosC:nc){
             System.out.println(naviosC);
         }
         for(NavioGraneleiro naviosG:ng){
             System.out.println(naviosG);
         }
    }
}

