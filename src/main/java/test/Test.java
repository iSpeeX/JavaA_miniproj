package test;

import java.util.List;
import dao.EleveDAO;
import metier.Eleve;
import metier.Formateur;
import metier.Identite;

public class Test {
	public static void main(String[] args) {

		// Config eleve Mathieu FOUCHER
    	Eleve el1 = new Eleve();
    	el1.setNote(18);
        
        Identite id1 = new Identite();
        id1.setNom("FOUCHER");
        id1.setPrenom("Mathieu");
        id1.setAge(25);
        
        el1.setIdentite(id1);
        
        // Config eleve Patrick BOZIN
        Eleve el2 = new Eleve();
        el2.setNote(15);
        
        Identite id2 = new Identite();
        id2.setNom("BOZIN");
        id2.setPrenom("Patrick");
        id2.setAge(18);
        
        el2.setIdentite(id2);
        
        // Ajouts des eleves
        EleveDAO elDao = new EleveDAO();
        elDao.addEleve(el1);
        elDao.addEleve(el2);
        
        List<Eleve> get_stud = elDao.getEleves();
        for (Eleve stud :get_stud) {
        	System.out.println(stud);
        }
        
     // Utilisation de la requête paramétrée qui filtre sur le nom DUBOIS
        List<Eleve> list_stud = elDao.getEleveByNom("BOZIN");
        for (Eleve stud :list_stud) {
        	System.out.println(stud);
        }
        
     // Utilisation de la requête paramétrée qui supprime des données
        elDao.deleteEleve(1);
    }
}
