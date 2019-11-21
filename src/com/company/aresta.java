package com.company;

public class aresta {
    private int peso;
    private Node no;
    public aresta(Node i, int pes){
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
