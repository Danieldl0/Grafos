import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {
	
	private int[][] matriz;
	private int qtdVertices;
	private List<Vertice> vertices;
	
	private final int loopValue = 2;
	private final int normalValue = 1;
	
	public MatrizAdjacencia(List<Vertice> vertices) {
		this.vertices = vertices;
		this.qtdVertices = vertices.size();
		this.matriz = new int[qtdVertices][qtdVertices];
	}
	
	public void conectarVertices(int indiceVerticeInicial, int indiceVerticeFinal) {
		Vertice verticeInicial = this.vertices.get(indiceVerticeInicial);
		Vertice verticeFinal = this.vertices.get(indiceVerticeFinal);
		if(indiceVerticeInicial == indiceVerticeFinal) {
			matriz[indiceVerticeInicial][indiceVerticeInicial] += 1;
			verticeInicial.addGrau(loopValue);
		}else {
			matriz[indiceVerticeInicial][indiceVerticeFinal] += 1;
			verticeInicial.addGrau(normalValue);
			matriz[indiceVerticeFinal][indiceVerticeInicial] += 1;
			verticeFinal.addGrau(normalValue);
		}
	}
	
	public List<Vertice> getAdjacentes(int indiceVertice){
		int linha = indiceVertice;
		List<Vertice> adjacentes = new ArrayList<>();
		for(int j = 0; j < vertices.size(); j++) {
			if(matriz[linha][j] != 0) {
				Vertice tempVertice = this.vertices.get(j);
				adjacentes.add(tempVertice);
			}
		}
		
		return adjacentes;
	}

	
	
	public void getMatriz() {
		for(int i = 0; i < this.qtdVertices; i++) {
			System.out.print("V"+i+ ": ");
			for(int j = 0; j < this.qtdVertices; j++) {
				System.out.print(this.matriz[i][j] + " | ");
			}
			System.out.println("\n");
		}
	
	}
	
	
	
	
}
