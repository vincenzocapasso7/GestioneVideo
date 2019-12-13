package is.gestionevideo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import is.gestionevideo.database.DBManager;

public class InizializzaDB {

	public static void main(String[] args) {

		try {
			
			Connection conn = DBManager.getConnection();
			
			String query;
			
			query = "CREATE TABLE VIDEO("
					+" ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+" NOME VARCHAR(30),"
					+" DATA DATE,"
					+" SPORT VARCHAR(30),"
					+" TIPO VARCHAR(30)"
					+");";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
			}
			
			
			query = "CREATE TABLE GIORNALISTI("
					+" ID_VIDEO INT NOT NULL,"
					+" NOME VARCHAR(30) NOT NULL,"
					+" COGNOME VARCHAR(30) NOT NULL,"
					+" PRIMARY KEY(ID_VIDEO,NOME,COGNOME)"
					+");";
			
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
			}
			
			
			
			System.out.println("Inizializzazione DB completata.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
