package com.company;

import java.lang.reflect.Array;
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

        public boolean dup(int x, int y, ArrayList<Cam> nos){
            for(Cam node : nos){
                if(node.getID_principal()==x && node.getID_ligacao()==y || node.getID_principal()==y && node.getID_ligacao()==x)
                    return false;
            }
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
            ArrayList<Integer> ignorar = new ArrayList<>();
            int marcador =0;
            for(Cam menor : ordenado){
                if(marcador == 0){
                    marcador++;
                    caminho.add(menor);
                    ignorar.add(menor.getID_principal());
                    ignorar.add(menor.getID_ligacao());
                }
                if(!(ignorar.contains(menor.getID_ligacao())&& ignorar.contains(menor.getID_principal()))){
                    caminho.add(menor);
                    if(!ignorar.contains(menor.getID_principal())){
                        ignorar.add(menor.getID_principal());
                    }else ignorar.add(menor.getID_ligacao());
                }
            }
            return caminho;
        }



}
