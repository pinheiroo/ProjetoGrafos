import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        try {
            GrafoAtores grafo = new GrafoAtores("teste.txt");
            grafo.printGrafoNomes();
            grafo.printFilmeAtor();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo movies.txt");
        }
    }
}
