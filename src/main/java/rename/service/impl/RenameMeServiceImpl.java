package rename.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rename.dao.RenameMeDao;
import rename.model.RenameMe;
import rename.service.RenameMeService;


@Service
public class RenameMeServiceImpl implements RenameMeService {
	
	@Autowired RenameMeDao renameMeDao;
	
	@Transactional(readOnly = true)
	public RenameMe get(Long id) {
		return renameMeDao.get(id);
	}

	@Transactional
	public void delete(RenameMe renameMe) {
		renameMeDao.delete(renameMe);
	}

	@Transactional(readOnly = true)
	public List<RenameMe> findAll() {
		return renameMeDao.findAll();
	}

	@Transactional
	public void save(RenameMe renameMe) {
		renameMeDao.save(renameMe);
	}

	@Transactional
	public void saveAll(List<RenameMe> list) {
		for (RenameMe renameMe : list)
			renameMeDao.save(renameMe);
	}
	
}
