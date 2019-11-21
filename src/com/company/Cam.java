package com.company;

public class Cam extends Comparable{
    private int ID_principal, ID_ligacao;

    public Cam(int remetente, int destino){
        ID_principal = remetente;
        ID_ligacao = destino;
    }

    public int getID_principal() {
        return ID_principal;
    }
    public int getID_ligacao() {
        return ID_ligacao;
    }

    @Override
    public String toString() {
        return ("No:["+ ID_principal +"] -> ["+ ID_ligacao+"] | ");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
