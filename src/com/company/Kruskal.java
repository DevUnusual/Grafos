package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
        private static ArrayList<Node> graph ;

        private Node find(int x){
            for(Node i : graph){
                if(x == i.getId()) return i;
            }
            return null;
        }

        private ArrayList<Integer> ligacoes(int id){//retorna as ligaçoes ordenadas
            Node a = find(id);
            if(a==null){
                return null;
            }
            return a.getLigacoes();
        }

        /*private boolean finish(ArrayList<Integer> ignorar){
            ArrayList<Integer> no = new ArrayList<>();
            for(Node x : graph){
                no.add(x.getId());
            }
            if(ignorar.containsAll(no)){
                return true;
            }
            return false;
        }*/

        public boolean dup(int x, int y, ArrayList<Cam> nos){
            for(Cam node : nos){
                if(node.getID_principal()==x && node.getID_ligacao()==y || node.getID_principal()==y && node.getID_ligacao()==x)
                    return false;
            }
            return true;
        }

        public ArrayList<Cam> linkActive(ArrayList<Cam> caminho, int id){
            ArrayList<Cam> ativos = new ArrayList<>();
            for(Cam i : caminho){
                if(i.getID_principal() == id || i.getID_ligacao() == id) ativos.add(i);
            }
            return ativos;
        }

        public boolean ciclo(int atual, ArrayList<Cam> caminho , ArrayList<Integer> ignorar, int fim){
            int []pos = {atual, fim};
            if(atual == fim ) return true;
            for(Cam inicio : linkActive(caminho, pos[0])){
                int alvo = (pos[0] == inicio.getID_principal()) ? inicio.getID_ligacao():inicio.getID_principal();
                if(ignorar.contains(alvo)) continue;
                ignorar.add(alvo);
                return ciclo(pos[0],caminho,ignorar, fim);
            }
            return false;
        }

        private boolean cicle(Cam atual, ArrayList<Cam> caminho ){
            if(ciclo(atual.getID_principal(),caminho,new ArrayList<Integer>(),atual.getID_ligacao())) return false;

            return true;
        }

        private ArrayList<Cam> ordenacaoGraph(Grafo graph){
            ArrayList<Cam> nodes = new ArrayList<>();
            ArrayList<Integer> No1 , No1lig ;
            No1 = new ArrayList<>();
            No1lig = new ArrayList<>();
            int marcador = 0;
            for(Node node1 : graph.getGrafo()){
                for(int lig : node1.getLigacoes()){
                    if(marcador ==0) {
                        nodes.add(new Cam(node1.getId(), lig, node1.getPeso(lig)));
                        No1.add(node1.getId());
                        No1lig.add(lig);
                        marcador++;
                    }else if(dup(node1.getId(), lig, nodes)){
                        nodes.add(new Cam(node1.getId(), lig, node1.getPeso(lig)));
                        No1.add(node1.getId());
                        No1lig.add(lig);
                    }
                }
            }
            Collections.sort(nodes);
            return nodes;
        }


        public ArrayList<Cam> kruskal(Grafo g){
            ArrayList<Cam> ordenado = ordenacaoGraph(g);
            ArrayList<Cam> caminho = new ArrayList<>();
            int marcador =0;
            for(Cam menor : ordenado){
                if(marcador == 0){
                    marcador++;
                    caminho.add(menor);
                }else if(cicle(menor, caminho)){
                    caminho.add(menor);
                }
            }
            return caminho;
        }



}
