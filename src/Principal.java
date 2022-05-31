

public class Principal {
	
	public static void main(String args[]) {
		
		/*Vertice v1 = new Vertice("v1");
		Vertice v2 = new Vertice("v2");
		Vertice v3 = new Vertice("v3");
		Vertice v4 = new Vertice("v4");*/
		

		Grafo grafo = new Grafo(5);
			
		try {
			grafo.adicionarVertice("v0");
			grafo.adicionarVertice("v1");
			grafo.adicionarVertice("v2");
			grafo.adicionarVertice("v3");
			grafo.adicionarVertice("v4");
			
			grafo.conectarVertices("v0", "v3");
			grafo.conectarVertices("v0", "v4");
			grafo.conectarVertices("v1", "v3");
			grafo.conectarVertices("v1", "v4");
			grafo.conectarVertices("v2", "v3");
			grafo.conectarVertices("v2", "v3");
			grafo.conectarVertices("v2", "v2");
			grafo.conectarVertices("v3", "v4");
			
			System.out.println(grafo.getVertice("v4").getGrau());
			
			System.out.println("Vizinhos de V2");
			for(Vertice v : grafo.getAdjacentes("v2")) {
				System.out.print(v.getRotulo() + ", ");
			}
			
		}catch(Exception e) {
			System.out.println("Error ao criar o grafo.");
			System.out.println("Mensagem: " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("\n");
		
		grafo.getMatrizAdjacencia();
		
		System.out.println("ordem: " + grafo.getQrdem());
		
		System.out.println("tamanho: " + grafo.qtTamanho());
		
	}

}
