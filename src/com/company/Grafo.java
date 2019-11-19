package com.company;

import java.util.ArrayList;

public class Grafo{
    private ArrayList<Node> graph = new ArrayList<>();

    private boolean verificar(int id){
        for(Node x : graph){
            if(x.getId() == id) return false;
        }
        return true;
    }

    private Node find(int x){
        for(Node i : graph){
            if(x == i.getId()) return i;
        }
        return null;
    }

    public void addNode(int id){
        if(verificar(id)) graph.add(new Node(id));
    }

    public void ligar(int id1 ,int id2, int peso){
        if(id1 == id2){
            System.err.println("Ambos ids iguais nao permitida a ligação.");
            return ;
        }
        Node alvo = find(id1);
        Node ligacao  = find(id2);
        alvo.addAresta(ligacao,peso);
    }

    public ArrayList<Node> getGrafo(){
        return graph;
    }

    @Override
    public String toString() {
        String x = "Grafo: \n";
        for(Node i : graph){
            x += i.toString();
        }
        return x;
    }



/*    public boolean ciclo(ArrayList<Integer> ids, int id){

    }
    public String Kruskal(int id){//qual node iniciar
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> caminho = new ArrayList<>();
        ids.addAll(ligacoes(id));
        caminho.add(id);

        int verificador = 0;
        int []temp = new int[2];
        Node principal = find(id);
        for (int i : ids){
            if(verificador==0) temp = new int[]{i, principal.getPeso(i)};
            else if( principal.getPeso(i)> temp[1]) temp = new int[]{i, principal.getPeso(i)};
        }
        kruskal(id, temp[0], ids, caminho);
        return "";
    }

    private ArrayList<Integer> kruskal(int id ,int id2, ArrayList<Integer> ligacoes, ArrayList<Integer> caminho){//id do node 1, id do node 2, array de ligações, array do caminho ja percorrido
        if(ligKruskal(caminho, id, id2)){
            caminho.add(id);
            return caminho;
        }
        int verificador =0;
        int []temp = new int[2];
        Node principal = find(id);
        for (int i : ligacoes){
            if(verificador==0) temp = new int[]{i, principal.getPeso(i)};
            else if( principal.getPeso(i)> temp[1]) temp = new int[]{i, principal.getPeso(i)};
        }
//            Node y = find(i);
        return null;
    }

    private boolean ligKruskal(ArrayList<Integer> caminho, int id1, int id2) {
        ArrayList<Integer>[] ligacoes = new ArrayList[caminho.size()];]


    }*/
}
