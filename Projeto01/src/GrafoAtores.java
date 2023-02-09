
import java.io.*;
import java.util.ArrayList;

public class GrafoAtores {

    private Grafo grafo;                        
    private ArrayList<String> nomes;  
    
    public static void main(String[] args) throws IOException {
        GrafoAtores grafo = new GrafoAtores("movies.txt");
        grafo.printGrafoNomes();
    }
 
    public GrafoAtores(String nomeArquivo) throws IOException{
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
                filme = s.split("/"); //pode dar ero
                for(int i=1; i<filme.length;i++){
                    if(!contem(filme[i])){
                        nomes.add(filme[i]);
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

        try{
            String s = br.readLine(); 
            String[] filme = new String[]{};
            while (s != null) {
                filme = s.split("/"); 
                for(int i=1; i<filme.length-1;i++){
                    for (int j=i+1; j<filme.length; j++){
                        if(!grafo.adj(indice(filme[i])).contains(indice(filme[j]))) grafo.adicionaAresta(indice(filme[i]), indice(filme[j]));
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

    public boolean contem(String s) {
        for(String nome:nomes)
        	if(nome.equals(s))
        		return true;
        return false;
    }

    public int indice(String s) {
        int i=0;
        for(String nome: nomes){
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
    		return nomes.get(v);
    	
    	return null;

    }

    public Grafo G() {
        return grafo;
    }

    
    /* public String toString(){
        String strLista = new String();
        for (int i=0;i<nomes.size();i++){
            strLista += i + "->" + nomes.get(i) + "\n";
        } 
        return strLista;
    } */

    public void printGrafoNomes(){
        for(int i=0;i<nomes.size();i++){
            System.out.print(nome(i) + "->");
            for(int j=0; j<grafo.adj(i).size();j++){
            System.out.print(nome(grafo.adj(i).get(j)) + " ");
        }
        System.out.println();
    }

    }

}
