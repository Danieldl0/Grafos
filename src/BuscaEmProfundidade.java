import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BuscaEmProfundidade {
	
	private Grafo grafo;
	private Stack<Vertice> pilha;
	private Set<String> visitados;
	
	public BuscaEmProfundidade(Grafo grafo) {
		this.grafo = grafo;
		this.pilha = new Stack<Vertice>();
		this.visitados = new LinkedHashSet<String>();
	}
	
	public List<Vertice> buscaCaminho(String rotuloVertice) throws Exception{
		
		List<Vertice> verticesVisitados = new ArrayList<Vertice>();
		
		Vertice origem = grafo.getVertice(rotuloVertice);
		
		pilha.push(origem);
		visitados.add(rotuloVertice);
		
		while(!pilha.isEmpty()) {
			Vertice atual = pilha.pop();
			
			verticesVisitados.add(atual);
			
			for(Vertice vizinho : grafo.getAdjacentes(atual.getRotulo())) {
				if(!visitados.contains(vizinho.getRotulo())) {
					pilha.push(vizinho);
					visitados.add(vizinho.getRotulo());
				}
			}
					
		}
		
		
		return verticesVisitados;
	}

}
