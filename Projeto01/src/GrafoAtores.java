import java.io.*;
import java.util.*;

public class GrafoAtores {

    private Grafo grafo;                      
    private ArrayList<String> atores;
    private ArrayList<ArrayList<String>> FilmeAtor;
    

    public GrafoAtores(String nomeArquivo) throws IOException{
        atores = new ArrayList<String>();
        FilmeAtor = new ArrayList<ArrayList<String>>();
        setLista(nomeArquivo);
        grafo = new Grafo(atores.size());
        setGrafo(nomeArquivo);
    }

    public void setLista(String nomeArquivo) throws IOException{
        InputStream is = new FileInputStream(nomeArquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String[] dados;

        try{
            String linha = br.readLine(); 
            while (linha != null) {
                dados = linha.split("/"); 
                String filme = dados[0];
                for(int i=1; i<dados.length;i++){
                    String ator = dados[i];
                    if(!contem(ator)){
                        atores.add(ator);
                        ArrayList<String> listaFilmes = new ArrayList<String>();
                        listaFilmes.add(filme);
                        FilmeAtor.add(listaFilmes);
                    }else{
                        FilmeAtor.get(indice(ator)).add(filme);
                    }
                }
                linha = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setGrafo(String nomeArquivo) throws IOException{
        InputStream is = new FileInputStream(nomeArquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try{
            String linha = br.readLine(); 
            while (linha != null) {
                String[] dados;
                dados = linha.split("/"); 
                for(int i=1; i<dados.length-1;i++){
                    for (int j=i+1; j<dados.length; j++){
                        String ator1 = dados[i];
                        String ator2 = dados[j];
                        if(!grafo.adj(indice(ator1)).contains(indice(ator2))){
                            grafo.adicionaAresta(indice(ator1), indice(ator2));
                        }
                            
                    }
                    
                }
                linha = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean contem(String s) {
        for(String nome:atores)
        	if(nome.equals(s))
        		return true;
        return false;
    }

    public int indice(String s) {
        int i=0;
        for(String nome: atores){
        	if(nome.equals(s))
        		return i;
            else
                i++;
        }
        return -1;      
    }


    public String nome(int v) {
    
    	int V = grafo.getV();
    	if(v>=0 && v<V)
    		return atores.get(v);
    	
    	return null;

    }

    public Grafo G() {
        return grafo;
    }

    
    public void printGrafoNomes(){
        System.out.printf("\nRelacoes entre atores:\n");
        for(int i=0;i<atores.size();i++){
            System.out.printf(atores.get(i) + "-> ");
            for(int j=0; j<grafo.adj(i).size();j++){
                System.out.printf(nome(grafo.adj(i).get(j)) + " ");
            }
            System.out.println();
        }

    }

    public void printFilmeAtor(){
        System.out.printf("\nFilmes estrelados por:\n");
        for(int i=0;i<FilmeAtor.size();i++){
            System.out.println(atores.get(i) + "->" + FilmeAtor.get(i));
        }

    }

    public void printFrequencia(String ator){
        int indice = indice(ator);
        countFreq(G().BFS(indice), G().BFS(indice).length);
    }

    public void countFreq(int arr[], int n){

        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);

        System.out.println("Numero Bacon     Frequencias\n------------------------------");
        
        int infinito = 0;

        for (int i = 0; i < n; i++) {
    
            if (visited[i] == true){
                continue;
            }
    
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            if(arr[i]==0){
               infinito = count-1;
               System.out.println("     0                1");
            }else{
                System.out.println("     "+arr[i] + "                " + count);
            }
            
        }
        System.out.println("  Infinito            " + infinito);
    }
 



    public void printCaminhoAtores(String ator, String origem){
        int[] vetor = grafo.BFS(indice(origem));
        System.out.println(ator+" tem número de "+origem+" = "+vetor[indice(ator)]);

        caminhoAtores(ator,origem);
    }

    public int caminhoAtores(String ator, String origem){
        int ator1 = indice(ator);
        int ator2 = indice(origem);
        int[] vetor = grafo.BFS(ator2);
        int prox=0;

        if(ator1==ator2){
            return 0;
        }
        else{
            for(int i=0; i<grafo.adj(ator1).size(); i++){
                if(vetor[grafo.adj(ator1).get(i)]==vetor[ator1]-1){
                    prox = grafo.adj(ator1).get(i);
                    for(int j=0; j<FilmeAtor.get(prox).size();j++){
                        for(int k=0; k<FilmeAtor.get(ator1).size(); k++){
                            if(FilmeAtor.get(prox).get(j).equals(FilmeAtor.get(ator1).get(k))){
                                System.out.println(ator+" fez "+FilmeAtor.get(ator1).get(k)+" com "+nome(prox));
                            }

                        }

                    }
                }
            }
            return caminhoAtores(nome(prox),origem);
        }
    }
}
