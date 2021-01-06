package org.acme.graph.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

/**
 * 
 * Un arc matérialisé par un sommet source et un sommet cible
 * 
 * @author MBorne
 *
 */
public class Edge {
	/**
	 * Identifiant de l'arc
	 */
	private String id;

	/**
	 * Sommet initial
	 */
	private Vertex source;

	/**
	 * Sommet final
	 */
	private Vertex target;
	
	private LineString lineString;
	
	Edge(Vertex source, Vertex target) {
		this.source = source;
		this.target = target;
		source.getoutEdges().add(this);
		target.getInEdges().add(this);
		
		Coordinate[] coordinates = {source.getCoordinate(), target.getCoordinate()};
		GeometryFactory gf = new GeometryFactory();
		LineString l = gf.createLineString(coordinates);
		lineString = l;	
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIdentityInfo(
		    generator=ObjectIdGenerators.PropertyGenerator.class, 
		    property="id"
		)

	  @JsonIdentityReference(alwaysAsId=true)
	public Vertex getSource() {
		return source;
	}

	/*public void setSource(Vertex source) {
		this.source = source;
	}
	*/

	 @JsonIdentityReference(alwaysAsId=true)
	public Vertex getTarget() {
		return target;
	}

	/*
	public void setTarget(Vertex target) {
		this.target = target;
	}
	*/
	
	/**
	 * dijkstra - coût de parcours de l'arc (distance géométrique)
	 * 
	 * @return
	 */
	public double getCost() {
		return source.getCoordinate().distance(target.getCoordinate());
	}

	@Override
	public String toString() {
		return id + " (" + source + "->" + target + ")";
	}
	
	public LineString getGeometry() {
		return this.lineString;
	}

	public void setLineString(LineString lineString) {
		this.lineString = lineString;
	}
	

}
