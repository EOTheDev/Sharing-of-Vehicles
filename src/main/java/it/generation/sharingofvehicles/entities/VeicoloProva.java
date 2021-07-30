package it.generation.sharingofvehicles.entities;

public class VeicoloProva {
    public static void main(String[] args) {
        
        Veicolo ve =new Veicolo();
        ve.setTipologia("auto");
        ve.setRuote(5);
        System.out.println(ve.getRuote());
    }
    
}
