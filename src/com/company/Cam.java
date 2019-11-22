package com.company;

public class Cam implements Comparable<Cam> {
    private int ID_principal, ID_ligacao, peso;

    public Cam(int remetente, int destino, int pes){
        ID_principal = remetente;
        ID_ligacao = destino;
        peso = pes;
    }

    public int getID_principal() {
        return ID_principal;
    }
    public int getID_ligacao() {
        return ID_ligacao;
    }

    @Override
    public String toString() {
        return ("No:["+ ID_principal +"] -> ["+ ID_ligacao+"] Peso:"+peso+" | ");
    }

    @Override
    public int compareTo(Cam o) {
        if(peso < o.peso) return -1;
        if(peso>o.peso) return 1;
        return 0;
    }
}
