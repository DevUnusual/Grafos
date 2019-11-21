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
        ArrayList<cam> caminho = new ArrayList<>();
        ArrayList<Integer> ignorar = new ArrayList<>();
        ignorar.add(id);
        //--------------------------
        int temp = -1;
        int ligacao = 0, peso = 0;
        //--------------------------

        for(int atual : find(id).getLigacoes()){//procurar a primeira ligação menor relacionada ao primeiro nó.
            if(temp == -1){
                ligacao = atual;
                peso = find(atual).getPeso(id);
                temp++;
            }else if(find(atual).getPeso(id) < peso){
                ligacao = atual;
                peso = find(atual).getPeso(id);
            }
        }

        ignorar.add(ligacao);//adicionar o menor a lista de ignorar
        caminho.add(new cam(id, ligacao));//atualizar caminho com a primeira aresta



        caminho = kruskal(caminho, ignorar);
        System.out.println("Arvore Minima encontrada Iniciando de " + id + ":");
        System.out.print("Caminho: ");
        for(cam x : caminho)
        System.out.print(x);
    }


    private static ArrayList<cam> kruskal(ArrayList<cam> caminho, ArrayList<Integer> ignorar){
        if(finish(ignorar)){
            return caminho;
        }

        //--------------------------
        int temp = -1;
        int ligacao = 0, peso = 0;
        int id=0;
        boolean atribuir = false;
        //--------------------------

        for(int node : ignorar) {
            for (int liga : find(node).getLigacoes()) {
                if(node != liga && !ignorar.contains(liga))
                if (temp == -1 ) {
                    id = node;
                    ligacao = liga;
                    peso = find(node).getPeso(liga);
                    atribuir = true;
                    temp++;
                } else if (find(node).getPeso(liga) < peso) {
                    id = node;
                    ligacao = liga;
                    peso = find(node).getPeso(liga);
                    atribuir = true;
                }
            }
//            if (temp != -1) temp = -1;
        }

        if(atribuir){
            ignorar.add(ligacao);
            caminho.add(new cam(id, ligacao));
        }

        return kruskal(caminho, ignorar);
    }
}
