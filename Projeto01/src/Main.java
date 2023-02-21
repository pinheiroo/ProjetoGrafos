import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            
            String nomeArquivo;
            System.out.println("Digite o nome do arquivo: ");
            nomeArquivo = in.nextLine();
            String nomeBacon;
            System.out.println("Digite o nome do ator a ser buscado (Exemplo Bacon, Kevin): ");
            nomeBacon = in.nextLine();
            String atorLigar;
            System.out.println("Digite o nome do ator para ligar à bacon(Exemplo Dane, Cynthia): ");
            atorLigar = in.nextLine();
            in.close();


            GrafoAtores grafoAtores = new GrafoAtores(nomeArquivo);
            System.out.println("Caminho do ator:");
            System.out.println();
            System.out.println();
            grafoAtores.printCaminhoAtores(atorLigar,nomeBacon);
            System.out.println();
            System.out.println();
            System.out.println("Frequencia de Bacon:");
            System.out.println();
            System.out.println();
            grafoAtores.printFrequencia(nomeBacon);
            System.out.println();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
