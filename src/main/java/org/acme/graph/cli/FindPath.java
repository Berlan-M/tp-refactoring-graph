package org.acme.graph.cli;

import java.io.File;
import java.util.List;

import org.acme.graph.io.XmlGraphReader;
import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.acme.graph.routing.DijkstraPathFinder;

/**
 * 
 * Application en ligne de commande pour le calcul d'un plus chemin entre
 * deux points.
 * 
 * @author MBorne
 *
 */
public class FindPath 
{
    public static void main( String[] args ) throws Exception
    {
    	if ( args.length != 3 ){
    		System.out.println("<path> <source> <target>");
    		System.out.println("${project_loc}/src/test/resources/graph/01.xml a c");
    		System.exit(1);
    	}
    	// Chargement du graph...
    	File graphFile = new File(args[0]);
    	if ( ! graphFile.exists() ){
    		System.err.println("file not found : "+graphFile.getAbsolutePath());
    	}
    	Graph graph = XmlGraphReader.read(graphFile);
    	
    	// Récupération source et target
    	Vertex source = graph.findVertex(args[1]);
    	if ( source == null ){
    		System.err.println("vertex "+args[1]+" not found");
    	}
    	Vertex target = graph.findVertex(args[2]);
    	if ( target == null ){
    		System.err.println("vertex "+args[2]+" not found");
    	}
    	
    	DijkstraPathFinder pathFinder = new DijkstraPathFinder(graph);
    	List<Edge> pathEdges = pathFinder.findPath(source, target);
    	if ( pathEdges == null ){
    		System.out.println("path not found");
    		return ;
    	}
    	System.out.println("Chemin trouvé : ");
    	for (Edge pathEdge : pathEdges) {
			System.out.println(pathEdge.getSource().getId()+" -> "+pathEdge.getTarget().getId());
		}
    }
}