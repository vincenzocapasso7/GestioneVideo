package is.gestionevideo.control;

import java.sql.SQLException;
import java.util.ArrayList;

import is.gestionevideo.database.VideoDAOWithInheritance;
import is.gestionevideo.entity.Sport;
import is.gestionevideo.entity.Video;

public class GestioneVideo {

	ArrayList<Video> lista_video;
	
	
	public GestioneVideo() throws SQLException {
		
		lista_video = VideoDAOWithInheritance.readAll();
	}
	
	
	
	public ArrayList<Video> ricercaVideo(Sport s, String testo) {
		
		ArrayList<Video> lista_risultati = new ArrayList<Video>();
		
		
		for(Video v : lista_video) {
			
			if( (s == null || v.getSport().equals(s)) && 
				(testo == null || v.getNome().contains(testo)) ) {
				
				/* Nota: se uno dei parametri di input è null, 
				 * viene ignorato dalla ricerca
				 */
				
				lista_risultati.add(v);
			}
		}
		
		
		return lista_risultati;
	}
	
	
	
	public void caricaVideo(Video v) throws SQLException {
		
		lista_video.add(v);
		
		int id = VideoDAOWithInheritance.create(v);
		
		v.setId(id);
	}
	
	
	public void rimuoviVideo(Video v) throws SQLException {
		
		lista_video.remove(v);
		
		VideoDAOWithInheritance.delete(v);
	}	
	
	public void visualizzaVideo(Video v) {
		
	}
	
	public void attivaNotifiche() {
		
	}
	
	public int consultaVisualizzazioni(Video v) {
		return 0;
	}
}
