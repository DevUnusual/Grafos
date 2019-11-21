package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class Node {
    private int id;
    private ArrayList<aresta> no = new ArrayList<aresta>();

    public Node(int num){ id = num; }
    
    private boolean repetido(Node x){//node para ser verificado
        for(aresta y : no){
            if(y.getNoId() == x.id) return false;
        }
        return true;
    }

    public void addAresta(Node x, int peso){
        if(peso < 0){
            System.out.println("nao é permitido a atribuição negativa.");
        }else if(repetido(x)){
            if(x.getId() != id) no.add(new aresta(x, peso));
            if(this != x) x.addAresta(this, peso);
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getLigacoes(){
        ArrayList<Integer> ids = new ArrayList<>();
        for(aresta x : no){
            ids.add(x.getNoId());
        }
        Collections.sort(ids);
        return ids;
    }

    public int getPeso(int id){
        for(aresta x : no){
            if(x.getNoId() == id) return x.getPeso();
        }
        return -1;
    }

    @Override
    public String toString() {
        String a = "Node "+ id + " Ligações:\n";
        if(!no.isEmpty())
        for(aresta x : no){
            a += (x.toString() + "\n");
        }
        else{
            a+= "Sem ligações";
        }
        return a;
    }
}
