package it.polito.tdp.metrodeparis.model;

import java.util.List;
import java.util.Map;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.metrodeparis.DB.FermataDAO;
import it.polito.tdp.metrodeparis.DB.LineaDAO;


public class MetroDeParisModel {

	private WeightedMultigraph<Fermata,DefaultWeightedEdge> metroGraph=new WeightedMultigraph<Fermata,DefaultWeightedEdge>(DefaultWeightedEdge.class);
	
	private FermataDAO fdao=new FermataDAO();
	private LineaDAO ldao=new LineaDAO();
	
	private Map<Integer,Fermata> fermate;
	private Map<Integer,Linea> linee;
	private List<Connessione> connessioni;
	
	public void generaGrafo(){
		
		fermate=fdao.getFermate();
		linee=ldao.getLinee();
		connessioni=fdao.getConnessioni();
		
		
		for(Fermata f: fermate.values()){
			metroGraph.addVertex(f);
		}
		System.out.println(metroGraph.vertexSet().size());
		
		for(Connessione c:connessioni){
			Fermata f1=fermate.get(c.getIdP());
			Fermata f2=fermate.get(c.getIdA());
			Linea l=linee.get(c.getIdLinea());
			
			if(!metroGraph.containsEdge(f1,f2)){
				DefaultWeightedEdge dwe=metroGraph.addEdge(f1,f2);
				metroGraph.setEdgeWeight(dwe,calcolaPeso(l,f1,f2));
			}
		}
		System.out.println(metroGraph.edgeSet().size());
		
	}
	
	public Map<Integer,Fermata> getFermate(){
		return fermate;
	}
	
	public double calcolaPeso(Linea l,Fermata f1,Fermata f2){
		return LatLngTool.distance(new LatLng(f1.getCoordX(),f1.getCoordY()), new LatLng(f2.getCoordX(),f2.getCoordY()), LengthUnit.KILOMETER)/l.getVelocita();
	}
	
	
	public String camminoMinimo(Fermata f1,Fermata f2){
		List<DefaultWeightedEdge> archi=DijkstraShortestPath.findPathBetween(metroGraph,f1,f2);
		double tempo=0;
		String s="Percorso: ["+f1.toString()+", ";
		for(DefaultWeightedEdge dwe:archi){
			s+=metroGraph.getEdgeTarget(dwe).getNome()+", ";
			tempo+=(metroGraph.getEdgeWeight(dwe)+30)/60;
		}
		s+="]\n\nTempo di percorrenza stimato: "+tempo;
		return s;
		
	}
}
