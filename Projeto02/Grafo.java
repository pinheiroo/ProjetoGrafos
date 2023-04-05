import java.util.Arrays;
import java.util.PriorityQueue;

class Grafo{

    private int v;
    private int a=0;
    private int[][] adj;

    public Grafo(int v){
        this.v = v;
        adj = new int[v][v];
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                adj[i][j]=0;
            }
        }
    }
    
    public int getV(){
        return v;
    }
    public int getA(){
        return a;
    }
    public void adicionaAresta(int u, int v, int p){
        adj[u][v]=p;
        adj[v][u]=p;
        this.a++;
    }

    public int grau(int v){
        int i=0, c=0;
        while(i<adj[v].length){
            if(adj[v][i]!=0) c++;
            i++;
        }
        return c;
    }

    public int[] adj(int v){
        return adj[v];
    }

    public String toString(){
        String strLista = new String();
        for (int i=0;i<v;i++){
            strLista += "\n" + i + " -> ";
            for(int j=0;j<v;j++){
                strLista += adj[i][j] + "  ";
            }
        } 
        return strLista;
    }

    public int melhorLocalHospital(){
        int[] vet = new int[v]; 
        int min;
    
        for(int i=0; i<v; i++){
            vet[i]=getExcentricidade(i);
        }
        
        min = min(vet);
        return min;
    }

    private int min(int[] vet) {
        int min = vet[0]; 
        int u=0;
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] < min) {
                min = vet[i];
                u = i;
            }
        }
        return u;

    }

    public int getExcentricidade(int s){
        return max(dijkstra(s));
    }


    public int[] dijkstra(int s){
        int[] dist = new int[v];
        boolean[] visitado = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(v, (a, b) -> dist[a] - dist[b]);
        queue.offer(s);
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            visitado[u] = true;
            
            for(int v = 0; v < this.v; v++){
                if(adj[u][v] != 0 && !visitado[v] && dist[u] != Integer.MAX_VALUE && dist[u] + adj[u][v] < dist[v]){
                    dist[v] = dist[u] + adj[u][v];
                    queue.offer(v);
                }
            }
        }
        return dist;
    }

    public int max(int[] d) {
        int max = d[0]; 
        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        return max;
    }
    

}