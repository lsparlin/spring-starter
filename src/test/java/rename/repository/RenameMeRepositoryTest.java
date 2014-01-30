package rename.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;

@Transactional
public class RenameMeRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired RenameMeRepository renameMeRepo;
	
	@Test
	public void testFindOne() {
	    RenameMe renameMe = renameMeRepo.findOne(2);
	    assertNotNull(renameMe);
	    assertEquals(2, renameMe.getId());
	    assertEquals("Name 2", renameMe.getName());
	}
	
	@Test
	public void testFindAll() {
	    List<RenameMe> list = renameMeRepo.findAll();
	    assertEquals(4, list.size());
	}
	
	@Test
	public void testFindByName() {
		RenameMe renameMe = renameMeRepo.findByName("Name 1");
		assertNotNull(renameMe);
		assertEquals(1, renameMe.getId(), 0);
		
		renameMe = renameMeRepo.findByName("invalid");
		assertNull(renameMe);
	}
	
}
