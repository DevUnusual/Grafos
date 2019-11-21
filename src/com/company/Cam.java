package com.company;

import java.util.ArrayList;

public class Cam {
    private int ID_principal, ID_ligacao;
//    private ArrayList<cam> caminho = new ArrayList<>();

    public Cam(int remetente, int destino){
        ID_principal = remetente;
        ID_ligacao = destino;
    }

    /*public ArrayList<cam> getCaminho() {
        return caminho;
    }*/

    public int getID_principal() {
        return ID_principal;
    }
    public int getID_ligacao() {
        return ID_ligacao;
    }

//    public void add(int remetente, int destino){ if(remetente > 0 || destino > 0) caminho.add(new cam(remetente, destino));}

    @Override
    public String toString() {
        return ("No:["+ ID_principal +"] -> ["+ ID_ligacao+"] | ");
    }
}
