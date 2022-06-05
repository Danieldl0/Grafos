import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BuscaEmProfundidadeRecursiva {

	private Grafo grafo;
	private List<Vertice> caminho;
	private Set<String> visitados;
	
	
	public BuscaEmProfundidadeRecursiva(Grafo grafo) {
		this.grafo = grafo;
		this.caminho = new ArrayList<Vertice>();
		this.visitados = new LinkedHashSet<String>();
	}
	
	
	public void buscarCaminho(String rotuloVertice) throws Exception{
		
		if (visitados.size() == 0) {
			visitados.add(rotuloVertice);
		}
		
		caminho.add(grafo.getVertice(rotuloVertice));
		
		for( Vertice vizinho : grafo.getAdjacentes(rotuloVertice)) {
			if(!visitados.contains(vizinho.getRotulo())) {
				visitados.add(vizinho.getRotulo());
				buscarCaminho(vizinho.getRotulo());
			}
		}
	}
	
	public List<Vertice> getCaminho(){
		return Collections.unmodifiableList(caminho);
	}
	
	
}
