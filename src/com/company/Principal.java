package com.company;

public class Principal {
    public static void main(String[] args) {
        Grafo graph = new Grafo();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(0);
        /*graph.addNode(5);
        graph.addNode(6);

        graph.ligar(1, 6, 1);
        graph.ligar(1, 2, 2);
        graph.ligar(2, 3, 5);
        graph.ligar(2, 4, 7);
        graph.ligar(3, 1, 10);
        graph.ligar(3, 6, 4);
        graph.ligar(3, 5, 6);
        graph.ligar(3, 4, 1);
        graph.ligar(6, 5, 8);
        graph.ligar(5, 4, 1);*/
        graph.ligar(0,1,10);
        graph.ligar(0,2,6);
        graph.ligar(0,3,5);
        graph.ligar(1,3,15);
        graph.ligar(2,3,4);


        System.out.println(graph);

        //arvore minima com kruskal nesse caso que fiz é para ser (1-2, 1-6, 6-3, 3-4, 4-5)

        graph.kruskal(0);
    }
}
