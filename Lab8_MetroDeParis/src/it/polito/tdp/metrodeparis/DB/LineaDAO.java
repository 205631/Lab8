package it.polito.tdp.metrodeparis.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Linea;

public class LineaDAO {
	
public Map<Integer,Linea> getLinee(){
		
		Map<Integer,Linea> mapLinee=new HashMap<Integer,Linea>();
		
		Connection conn=DBConnect.getConnection();
		
		
		String sql="select id_linea, nome,velocita,intervallo,colore from linea";
		
		PreparedStatement st;
		
		try {
			st=conn.prepareStatement(sql);
			ResultSet res=st.executeQuery();
			
			while(res.next()){
				Linea l=new Linea(res.getInt("id_linea"),res.getString("nome"),res.getDouble("velocita"),res.getDouble("intervallo"),res.getString("colore"));
				mapLinee.put(l.getIdLinea(),l);
			}
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return mapLinee;
	}
}
