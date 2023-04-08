import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File arquivo = new File("grafo1.txt");
            Scanner in = new Scanner(arquivo);

            int vertices = in.nextInt();

            Grafo grafo = new Grafo(vertices);

            int arestas = in.nextInt();
            for (int i = 0; i < arestas; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int p = in.nextInt();
                grafo.adicionaAresta(u, v, p);
            }

            System.out.println("Grafo de "+grafo.getV()+" vertices e "+grafo.getA()+" arestas, com as arestas: v1 - v2: peso");
            grafo.printAdj();
            System.out.println("O melhor lugar para se posicionar um hospital nesse grafo eh no vertice: "+grafo.melhorLocalHospital());

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}

