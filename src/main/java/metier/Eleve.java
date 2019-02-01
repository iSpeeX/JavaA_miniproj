package metier;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Eleve implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO) //génération automatique 
	private long elID; 
	private int note;
	
	@Embedded
	private Identite identite;

	public long getElID() {
		return elID;
	}

	public int getNote() {
		return note;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setElID(long elID) {
		this.elID = elID;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	public String toString() {
        return "ID: " + getElID() +
               ", Identité: " + getIdentite() +
               ", Note: " + getNote();
    }

}
