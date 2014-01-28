package rename.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;
import rename.repository.RenameMeRepository;

/*
 * This test assumes CreateTestData.java inserted some records when the context was built
 */

@Transactional
public class HibernateRenameMeRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired RenameMeRepository renameMeRepo;
	
	@Test
	public void testFindByName() {
		RenameMe renameMe = renameMeRepo.findByName("Name 1");
		assertNotNull(renameMe);
		assertEquals(1, renameMe.getId(), 0);
		
		renameMe = renameMeRepo.findByName("invalid");
		assertNull(renameMe);
	}
	
}
