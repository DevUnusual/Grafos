package com.company;

import java.util.Collections;

public class Principal {
    public static void main(String[] args) {
        Grafo graph = new Grafo();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        /*graph.addNode(6);
        graph.addNode(7);

        graph.ligar(1,2,2);
        graph.ligar(1,4,7);
        graph.ligar(1,6,2);
        graph.ligar(2,6,5);
        graph.ligar(2,3,1);
        graph.ligar(2,4,4);
        graph.ligar(2,5,3);
        graph.ligar(3,6,4);
        graph.ligar(3,5,4);
        graph.ligar(4,5,1);
        graph.ligar(4,7,5);
        graph.ligar(5,7,7);*/
        graph.ligar(1,2,3);
        graph.ligar(1,5,5);
        graph.ligar(2,3,8);
        graph.ligar(2,5,1);
        graph.ligar(1,3,1);
        graph.ligar(3,4,10);
        graph.ligar(5,4,2);






        System.out.println(graph);

        System.out.println("Prim algorit:");
        Prim.SS(1,graph.getGrafo());

        Kruskal k = new Kruskal();
        System.out.println("\n kruskal Algoritmo:");
        System.out.println(k.kruskal(graph));
    }
}
