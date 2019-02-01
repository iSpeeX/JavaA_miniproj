package metier;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable 
public class Identite implements Serializable{  
    private String nom;
    private String prenom;
    private int age;
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getAge() {
		return age;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
	public String toString() {
        return "Nom: " + getNom() +
               ", Prénom: " + getPrenom() +
               ", Age: " + getAge();
    }
} 