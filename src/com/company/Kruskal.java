package com.company;

import java.util.ArrayList;

public class Kruskal {
        private static ArrayList<Node> graph ;
        public static void SS(int i, ArrayList<Node> grap){graph=grap;kruskal(i);}

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

        private static void kruskal(int id){

        }

}
