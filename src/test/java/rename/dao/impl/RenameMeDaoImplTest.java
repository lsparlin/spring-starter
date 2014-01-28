package rename.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.dao.RenameMeDao;
import rename.model.RenameMe;


@Transactional
public class RenameMeDaoImplTest extends DaoTest {
	
	@Autowired RenameMeDao renameMeDao;
	
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
