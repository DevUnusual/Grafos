package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Kruskal {
   /*     private static ArrayList<Node> graph ;

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
*/
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

        private Map<Integer, ArrayList<Integer>> iniMap(ArrayList<Node> graph){
            Map<Integer, ArrayList<Integer>> ignorar = new HashMap<>();
            for(Node i : graph){
                ignorar.put(i.getId(), new ArrayList<Integer>());
            }
            return ignorar;
        }
        private ArrayList<Integer> getMap(Map<Integer, ArrayList<Integer>> a, int id){
            return a.get(id);
        }
        public ArrayList<Cam> kruskal(Grafo g){
            ArrayList<Cam> ordenado = ordenacaoGraph(g);
            ArrayList<Cam> caminho = new ArrayList<>();
            Map<Integer, ArrayList<Integer>> ignorar = iniMap(g.getGrafo());
            int marcador =0;
            for(Cam menor : ordenado){
                if(marcador == 0){
                    marcador++;
                    caminho.add(menor);

                    ArrayList<Integer> lis = getMap(ignorar, menor.getID_principal());
                    lis.add(menor.getID_ligacao());
                    ignorar.put(menor.getID_principal(),lis);

                    lis = ignorar.get(menor.getID_ligacao());
                    lis.add(menor.getID_principal());
                    ignorar.put(menor.getID_ligacao(),lis);
                }
                if(!(ignorar.get(menor.getID_ligacao()).contains(menor.getID_principal()) &&
                        ignorar.get(menor.getID_principal()).contains(menor.getID_ligacao()))){

                    if(!getMap(ignorar,menor.getID_principal()).contains(menor.getID_ligacao())){
                        ArrayList<Integer> lis = ignorar.get(menor.getID_principal());
                        lis.add(menor.getID_ligacao());
                        ignorar.put(menor.getID_principal(), lis);
                        caminho.add(menor);
                    }else{
                        ArrayList<Integer> lis = ignorar.get(menor.getID_ligacao());
                        lis.add(menor.getID_principal());
                        ignorar.put(menor.getID_ligacao(), lis);
                        caminho.add(menor);
                    }
                }
            }
            return caminho;
        }



}
