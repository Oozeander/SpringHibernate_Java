package com.oozeander.dao.crud;

import java.util.List;

import com.oozeander.model.crud.Person;

/**
 * @author Oozeander
 *
 */
public interface PersonDao {
	/**
	 * Récupérer la liste des Personnes
	 *
	 * @return liste des personnes
	 */
	List<Person> get();

	/**
	 * Renvoie une Personne à partir de son identifiant
	 *
	 * @param identifiant
	 * @return personne
	 */
	Person get(Long id);

	/**
	 * Sauvegarde une personne
	 *
	 * @param personne
	 */
	void save(Person person);

	/**
	 * Modifie une personne à partir de son identifiant et des nouvelles
	 * informations
	 *
	 * @param identitfiant
	 * @param personne     (nouvelles informations)
	 */
	void update(Long id, Person person);

	/**
	 * Supprime une personne à partir de son identifiant
	 *
	 * @param identifiant
	 */
	void delete(Long id);
}