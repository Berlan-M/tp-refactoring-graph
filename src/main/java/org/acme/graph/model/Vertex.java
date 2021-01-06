package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graph
 * 
 * @author MBorne
 *
 */
public class Vertex {
	
	

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	/**
	 * dijkstra - coût pour atteindre le sommet
	 */
	

	Vertex() {
		this.inEdges = new ArrayList<Edge>();
		this.outEdges = new ArrayList<Edge>();
	}
	
	private List<Edge> inEdges;
	
	private List<Edge> outEdges;
	
	@JsonIgnore
	public Collection<Edge> getInEdges() {
		return this.inEdges;
	}
	
	@JsonIgnore
	public Collection<Edge> getoutEdges() {
		return this.outEdges;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	

	@Override
	public String toString() {
		return id;
	}
}
