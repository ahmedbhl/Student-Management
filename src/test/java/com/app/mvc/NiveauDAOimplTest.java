package com.app.mvc;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.mvc.entity.Niveau;
import com.app.mvc.services.INiveauService;
import com.app.mvc.services.impl.NiveauServiceImpl;

///TODO For Spring with Annotation configuration of appliCationcontext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})

/***************************************************************/

/// TODO For Spring 3.1.1 with XML configuration of appliCationcontext
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class NiveauDAOimplTest {

	/*public static Long idNiveau = null;

	@Autowired
	INiveauService INiveauService;

	//@Before
	@Test
	public void TestSaveNiveau() {

		int OldNiveauxSize = INiveauService.FindAll().size();
		Niveau niveau = new Niveau("Test Save From JUnit", "Test Save From JUnit");
		idNiveau = INiveauService.save(niveau).getIdNiveau();

		int NewNiveauxSize = INiveauService.FindAll().size();

		// Check before if the list of niveau not null and then check the size (OldNiveauxSize) of the list Niveau before persist Lower then (NewNiveauxSize) the new list after persist
		assertNotNull(INiveauService.FindAll());
		assertTrue(OldNiveauxSize < NewNiveauxSize);

	}

	@Ignore
	@Test
	public void TestINiveauService() {
		assertThat(INiveauService, instanceOf(NiveauServiceImpl.class));
	}

	@Test
	public void TestIfindByIdTrue() {
		Niveau niveau = INiveauService.findById(idNiveau);

		// First Method for testing if object not null
		assertTrue(niveau != null);

		// Secon Method for testing if object not null
		assertNotNull(niveau);

	}

	// TODO Check if FindAll return result not null
	@Test
	public void TestFindAll() {
		List<Niveau> niveaux = INiveauService.FindAll();

		assertTrue(niveaux != null);

		assertTrue(niveaux.size() > 0);

	}

	//@After
	@Test
	public void TestDeleteNiveau() {

		int OldNiveauxSize = INiveauService.FindAll().size();
		INiveauService.DeleteById(idNiveau);
		int NewNiveauxSize = INiveauService.FindAll().size();

		// Check if the size (OldNiveauxSize) of the list Niveau before persist lower then (NewNiveauxSize) the new list after persist
		assertTrue(OldNiveauxSize > NewNiveauxSize);

	}*/

}
