package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Eleve;

public class EleveDAO {
	
	EntityManagerFactory emf;

	public void addEleve(Eleve eleve) { //ajout l'�tudiant dans la BDD
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU
		emf = Persistence.createEntityManagerFactory("miniprojetjpa");
		//2.Construction d'un entity manager pour effectuer les op�rations CRUD et transaction
		EntityManager em = emf.createEntityManager(); 
		//3. Ouverture d'une transaction: 
			EntityTransaction tx = em.getTransaction(); 
			tx.begin(); 
			try{ 
		//4. persistence de mon object student 
			em.persist(eleve);//le traitement se fera toujours dans une transaction 
		//5. commit de la transaction : validation du traitement 
			tx.commit(); 
			}catch(Exception e) { 
		//Annuler les traitements 
			   if (tx != null) { 
					tx.rollback();  //annuler la transaction s'il y a une exception 
					e.printStackTrace();   //print 
			   } 
			 }finally{ //6. dans tous les cas on ferme 
				 em.close(); 
				 emf.close(); 
			 } 
       }
	
	// Requ�te param�tr�e qui donne la liste des �tudiants
	public List<Eleve> getEleves() { //lister tous les �tudiants 
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU
		emf = Persistence.createEntityManagerFactory("miniprojetjpa");
		//2.Construction d'un entity manager pour effectuer les op�rations CRUD et transaction
		EntityManager em = emf.createEntityManager(); 
		Query req=em.createQuery("SELECT s FROM Eleve s", Eleve.class); 
		List<Eleve> stud =req.getResultList(); 
		return stud;
	} 
	
	// Requ�te param�tr�e qui filtre sur le nom
	public List<Eleve> getEleveByNom(String nom) {
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU
		emf = Persistence.createEntityManagerFactory("miniprojetjpa");
		//2.Construction d'un entity manager pour effectuer les op�rations CRUD et transaction
		EntityManager em = emf.createEntityManager(); 
		Query req=em.createQuery("SELECT s FROM Eleve s WHERE nom=?1"); 
		req.setParameter(1,nom); 
		List<Eleve> stud =req.getResultList(); 
		return stud;
	}
	
	// Requ�te param�tr�e pour suppression des donn�es
	public void deleteEleve(long elID) { //Delete un �tudiant selon id 
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU
		emf = Persistence.createEntityManagerFactory("miniprojetjpa");
		//2.Construction d'un entity manager pour effectuer les op�rations CRUD et transaction
		EntityManager em = emf.createEntityManager(); 

		Eleve stu = em.find(Eleve.class,elID); 
		em.getTransaction().begin();
		em.remove(stu); 
		em.getTransaction().commit();
	}
}
