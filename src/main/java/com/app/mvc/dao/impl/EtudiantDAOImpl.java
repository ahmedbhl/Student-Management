package com.app.mvc.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.app.mvc.dao.IEtudiantDAO;
import com.app.mvc.entity.Etudiant;

public class EtudiantDAOImpl implements IEtudiantDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("From Etudiant e");
		return q.getResultList();
	}

	@Override
	public List<Etudiant> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Etudiant> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Etudiant> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Etudiant getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Etudiant> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> S save(S entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			em.persist(entity);
		}
		return entity;
	}

	@Override
	public Optional<Etudiant> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Etudiant.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Etudiant Etudiant = em.find(Etudiant.class, id);
		if (Etudiant != null) {
			em.remove(em.contains(Etudiant) ? Etudiant : em.merge(Etudiant));

		}
	}

	@Override
	public void delete(Etudiant entity) {
		// TODO Auto-generated method stub
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Etudiant> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Etudiant> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Etudiant> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean FindByMail(String mail) {
		Query q = em.createQuery("from Etudiant e where e.email=?1").setParameter(1, mail);
		if (!q.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Etudiant finByCin(int cin) {
		Query q = em.createQuery("from Etudiant e where e.cin=?1").setParameter(1, cin);
		return (Etudiant) q.getSingleResult();
	}

	@Override
	public Etudiant finByNom(String nom) {
		Query q = em.createQuery("from Etudiant e where e.nomFr=?1 OR e.nomAr=?1").setParameter(1, nom);
		return (Etudiant) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> finByClasse(String codeClasse) {

		Query q = em.createQuery("from Etudiant e where e.classe.codeClasse=?1").setParameter(1, codeClasse);

		// }

		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> finByParcour(String designation) {
		Query q = em.createQuery("from Etudiant e where e.classe.parcour.designParcours=?1").setParameter(1,
				designation);
		return (List<Etudiant>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> finByParcourNiveau(String designation, String niveau) {
		Query q = em
				.createQuery(
						"from Etudiant e where e.classe.parcour.designParcours=?1 AND (e.classe.parcour.niveau.designNiveauFr=?2 OR e.classe.parcour.niveau.designNiveauAr=?2)")
				.setParameter(1, designation).setParameter(2, niveau);
		return (List<Etudiant>) q.getResultList();
	}

	@Override
	public Boolean existByCin(int cin) {
		Query q = em.createQuery("from Etudiant e where e.cin=?1").setParameter(1, cin);
		if (!q.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

}
