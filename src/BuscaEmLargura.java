import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BuscaEmLargura {
	
	private Queue<Vertice> filaVertices;
	private Set<String> visitados;
	
	private Grafo grafo;
	
	public BuscaEmLargura(Grafo grafo) {
		this.filaVertices = new LinkedList<Vertice>();
		this.visitados = new LinkedHashSet<String>();
		
		this.grafo = grafo;
	}

	public List<Vertice> buscarCaminho(String rotuloVertice) throws Exception{
		List<Vertice> caminho = new ArrayList<Vertice>();
		
		Vertice origem = grafo.getVertice(rotuloVertice);
		
		filaVertices.add(origem);
		visitados.add(rotuloVertice);
		
		while(!filaVertices.isEmpty()){
			Vertice atual = filaVertices.poll();
			
			caminho.add(atual);
			
			for(Vertice vizinho : grafo.getAdjacentes(atual.getRotulo())) {
				if(!visitados.contains(vizinho.getRotulo())) {
					filaVertices.add(vizinho);
					visitados.add(vizinho.getRotulo());
				}
			}
		
		}
		return caminho;
	}

}
