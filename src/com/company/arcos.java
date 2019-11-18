package com.company;

public class arcos {
    private int peso;
    private Node no;
    public arcos(Node i, int pes){
        no = i;
        peso = pes;
    }

    public int getPeso() {
        return peso;
    }

    public int getNoId() {
        return no.getId();
    }

    @Override
    public String toString() {
        return ("Node: "+ getNoId() + " peso: "+ peso);
    }
}
