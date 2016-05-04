package it.polito.tdp.metrodeparis.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.metrodeparis.model.Connessione;
import it.polito.tdp.metrodeparis.model.Fermata;

public class FermataDAO {

	
	public Map<Integer,Fermata> getFermate(){

		
		Map<Integer,Fermata> mapFermate=new HashMap<Integer,Fermata>();
		
		Connection conn=DBConnect.getConnection();
		
		
		String sql="select id_fermata, nome,coordX,coordY from fermata";
		
		PreparedStatement st;
		
		try {
			st=conn.prepareStatement(sql);
			ResultSet res=st.executeQuery();
			
			while(res.next()){
				Fermata f=new Fermata(res.getInt("id_fermata"),res.getString("nome"),res.getDouble("coordX"),res.getDouble("coordY"));
				mapFermate.put(f.getIdFermata(),f);
			}
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return mapFermate;
	}
	
	public List<Connessione> getConnessioni(){
		List<Connessione> listConnessione=new ArrayList<Connessione>();
		
		Connection conn=DBConnect.getConnection();
		
		
		String sql="select id_linea,id_stazP,id_stazA from connessione";
		
		PreparedStatement st;
		
		try {
			st=conn.prepareStatement(sql);
			ResultSet res=st.executeQuery();
			
			while(res.next()){
				Connessione c=new Connessione(res.getInt("id_linea"),res.getInt("id_stazP"),res.getInt("id_stazA"));
				listConnessione.add(c);
			}
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return listConnessione;
	}
}
