import java.io.IOException;

public class Teste {
    
    public static void main(String[] args) throws IOException {
        Grafo g = new Grafo(8);
        g.adicionaAresta(1, 7, 1);
        g.adicionaAresta(6, 7, 1);
        g.adicionaAresta(3, 6, 1);
        g.adicionaAresta(0, 3, 1);
        g.adicionaAresta(3, 4, 1);
        g.adicionaAresta(2, 3, 1);
        g.adicionaAresta(3, 5, 1);
        System.out.println(g.melhorLocalHospital());

    }
}
