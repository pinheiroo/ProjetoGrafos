public class Aresta {
    private int origem;
    private int destino;
    private int peso;

    public Aresta(int origem, int destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigem(){
        return origem;
    }
    
    public int getDestino(){
        return destino;
    }

    public int getPeso(){
        return peso;
    }
}
