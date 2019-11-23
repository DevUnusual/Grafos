package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
        private static ArrayList<Node> graph ;

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

        public boolean dup(int x, int y, ArrayList<Cam> nos){
            for(Cam node : nos){
                if(node.getID_principal()==x && node.getID_ligacao()==y || node.getID_principal()==y && node.getID_ligacao()==x)
                    return false;
            }
            return true;
        }
        public boolean triangulo(Cam atual, Cam primario, Cam secundario){
        int restoPrimario = -1, restoSecundario = -1;
        if(atual.getID_principal() == primario.getID_principal() || atual.getID_ligacao() == primario.getID_principal()) restoPrimario = primario.getID_ligacao();
        if(atual.getID_principal() == primario.getID_ligacao() || atual.getID_ligacao() == primario.getID_ligacao()) restoPrimario = primario.getID_principal();
        if(atual.getID_ligacao() == secundario.getID_principal() || atual.getID_ligacao() == secundario.getID_principal()) restoSecundario = secundario.getID_ligacao();
        if(atual.getID_ligacao() == secundario.getID_ligacao() || atual.getID_ligacao() == secundario.getID_ligacao()) restoSecundario = secundario.getID_principal();
        if(restoPrimario == restoSecundario || restoPrimario == -1 || restoSecundario == -1) return true;
        return false;
        }

        private boolean cicle(Cam atual, ArrayList<Cam> caminho ){
            int principal = atual.getID_principal();
            int liga = atual.getID_ligacao();
            for(Cam inicio : caminho){
                if(inicio == atual) continue;
                if(principal == inicio.getID_principal() || principal == inicio.getID_ligacao()){
                    for(Cam meio : caminho){
                        if(inicio == meio) continue;
                        if(inicio.getID_principal() == meio.getID_principal() && liga == meio.getID_ligacao())
                    }
                }if(liga == inicio.getID_principal() || liga == inicio.getID_ligacao()){
                    for(Cam meio : caminho){
                        if(inicio == meio) continue;
                        if(inicio.getID_ligacao() == meio.getID_principal() || liga == meio.getID_ligacao() ){
                            if(triangulo(atual, inicio, meio))
                                return false;
                        }
                    }
                }
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
