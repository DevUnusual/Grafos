package com.company;

import java.util.ArrayList;

public class Grafo{
    private ArrayList<Node> graph = new ArrayList<>();

    private boolean verificar(int id){
        for(Node x : graph){
            if(x.getId() == id) return false;
        }
        return true;
    }

    public Node find(int x){
        for(Node i : graph){
            if(x == i.getId()) return i;
        }
        return null;
    }

    public void addNode(int id){
        if(verificar(id)) graph.add(new Node(id));
    }

    public void ligar(int id1 ,int id2, int peso){
        if(id1 == id2){
            System.err.println("Ambos ids iguais nao permitida a ligação.");
            return ;
        }
        Node alvo = find(id1);
        Node ligacao  = find(id2);
        alvo.addAresta(ligacao,peso);
    }

    public ArrayList<Node> getGrafo(){
        return graph;
    }

    @Override
    public String toString() {
        String x = "Grafo: \n";
        for(Node i : graph){
            x += i.toString();
        }
        return x;
    }

}
