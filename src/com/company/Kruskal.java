package com.company;

import java.util.ArrayList;

public class Kruskal{
    private static ArrayList<Node> graph ;
    public static void SS(int i, ArrayList<Node> grap){graph=grap;kruskal(i);}
//    public Kruskal(ArrayList<Node> grafo){
//        graph = grafo;
//    }

    private static Node find(int x){
        for(Node i : graph){
            if(x == i.getId()) return i;
        }
        return null;
    }

    private static ArrayList<Integer> ligacoes(int id){//retorna as ligaçoes ordenadas
        Node a = find(id);
        if(a==null){
            return null;
        }
        return a.getLigacoes();
    }

    private static boolean finish(ArrayList<Integer> ignorar){
        ArrayList<Integer> no = new ArrayList<>();
        for(Node x : graph){
            no.add(x.getId());
        }
        if(ignorar.containsAll(no)){
            return true;
        }
        return false;

    }

    private static void kruskal(int id){//id por onde começar
        if(find(id) == null) {
            System.err.println("Node não encontrado. verifique o id.");
            return ;
        }
        //Map<Node, Integer> cam = new HashMap<>();//------------------------------------------------------------
        ArrayList<Node> caminho = new ArrayList<>();
        ArrayList<Integer> ignorar = new ArrayList<>();
        caminho.add(find(id));
        ignorar.add(id);

        int verificador = 0;
        Node temp = null;
        Node Principal = find(id);
        for(int x : ligacoes(id)){
            if(verificador ==0){
                temp = find(x);
                verificador++;
            }
            else if(temp.getPeso(id) > find(x).getPeso(id)) temp = find(x);
        }
        caminho.add(temp);
        ignorar.add(temp.getId());
        caminho = kruskal(caminho, ignorar);
        System.out.println("Arvore Minima encontrada Iniciando de: " + id + ":");
        System.out.print("Caminho:");
        for(Node x : caminho){
            System.out.print(" "+x.getId() +" ->");
        }
    }


    private static ArrayList<Node> kruskal(ArrayList<Node> caminho, ArrayList<Integer> ignorar){
        if(finish(ignorar)){
            return caminho;
        }
        int verificador = 0;
        Node temp = null;
        int id;
        for (Node x : caminho) {
            for(int y : ligacoes(x.getId())){
                if(!ignorar.contains(y)) {
                    if (verificador == 0) {
                        temp = find(y);
                        id = x.getId();
                        verificador++;
                    } else if ((find(y).getPeso(x.getId()) < temp.getPeso(x.getId()))) {
                        temp = find(y);
                        id = x.getId();
                    }
                }
            }
        }
        caminho.add(temp);
        ignorar.add(temp.getId());
        return kruskal(caminho, ignorar);
    }
}
