package metier;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formateur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO) //génération automatique 
	private long foID; 
	private String experience;

	@Embedded
	private Identite identite;

	public long getFoID() {
		return foID;
	}

	public String getExperience() {
		return experience;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setFoID(long foID) {
		this.foID = foID;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	public String toString() {
        return "ID: " + getFoID() +
               ", Identité: " + getIdentite() +
               ", Expérience: " + getExperience();
    }

}
