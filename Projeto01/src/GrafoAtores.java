import java.io.*;
import java.util.ArrayList;

public class GrafoAtores {
    

    private Grafo grafo;                        // grafo com vértices numéricos 
    private ArrayList<String> nomes;          // faz o mapeamento índice --> nome
    // o número do vértice no grafo é usado como índice do vetor nomes


    /**
     * Inicializa o grafo a partir de um arquivo-texto 
     * @param nomeArquivo nome do arquivo-texto de entrada
     */
    public GrafoSimbolos(String nomeArquivo) {
        nomes = new ArrayList<String>();
        setLista(nomeArquivo);
        grafo = new Grafo(nomes.size());
        setGrafo(nomeArquivo);
    }

    public void setLista(String nomeArquivo) throws IOException{
        InputStream is = new FileInputStream(nomeArquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String[] filme;

        try{
            String s = br.readLine(); // primeira linha
            while (s != null) {
                System.out.println(s);
                filme = s.split("/"); //pode dar ero
                for(int i=1; i<filme.length;i++){
                    if(!nomes.contem(filme[i])){
                        nomes.setNomes(filme[i]);
                    }
                }
                s = br.readLine();
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
        String[] filme;

        try{
            String s = br.readLine(); // primeira linha
            while (s != null) {
                System.out.println(s);
                filme = s.split("/"); //pode dar ero
                for(int i=1; i<filme.length;i++){
                   
                }
                s = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setNomes(String nome){
        nomes.add(nome);
    }

    /**
     * O grafo contém o ator com nome {@code s}?
     * @param {@code s} nome do vértice
     * @return {@code true} se {@code s} é o nome de um vértice, e {@code false} caso contrário
     */
    public boolean contem(String s) {
        for(String nome : nomes )
        	if(nome.equals(s))
        		return true;
        return false;
    }

    /**
     * Retorna o inteiro associado com o ator cujo nome é {@code s}.
     * @param s o nome do ator
     * @return o inteiro (entre 0 e <em>|V|</em> - 1) associado ao nome {@code s}, se o ator existir no grafo, e -1 caso contrário
     */
    public int indice(String s) {
        for(int i=0; i<nomes.length; i++){
        	if(nomes[i].equals(s))
        		return i;
        }
        return -1;      
    }


    /**
     * Retorna o nome do ator associado ao inteiro {@code v}.
     * @param  v o inteiro correspondente a um vértice (entre 0 e <em>V</em> - 1)
     * @return o nome do vértice associado com o inteiro {@code v}
     * @throws IllegalArgumentException a menos que {@code 0 <= v < V}
     */
    public String nome(int v) {
    
    	int V = grafo.V();
    	if(v>=0 && v<V)
    		return nomes[v];
    	
    	return null;

    }



    /**
     * Retorna o grafo associado ao grafo de atores
     * @return o grafo contendo vértices rotulados com números
     */

    public Grafo G() {
        return grafo;
    }

    
    
}