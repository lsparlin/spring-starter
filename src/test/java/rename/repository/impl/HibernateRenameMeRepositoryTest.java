package rename.repository.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;
import rename.repository.RenameMeRepository;


@Transactional
public class HibernateRenameMeRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired RenameMeRepository renameMeDao;
	
	@Test
	public void all_fields_are_persisted() {
		RenameMe renameMe = new RenameMe();
		renameMe.setName("Name1");
		renameMeDao.save(renameMe);
		List<RenameMe> list = renameMeDao.findAll();
		Assert.assertEquals("Name1", list.get(0).getName());
		renameMeDao.delete(renameMe);
	}
	
}
