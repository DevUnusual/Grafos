package com.company;

public class Principal {
    public static void main(String[] args) {
        Grafo graph = new Grafo();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
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
        graph.ligar(5,7,7);

        System.out.println(graph);



        Kruskal.SS(1,graph.getGrafo());
    }
}
