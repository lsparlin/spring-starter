package rename.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;
import rename.repository.RenameMeRepository;
import rename.service.RenameMeService;


@Service
public class RenameMeServiceImpl implements RenameMeService {
	
	@Autowired RenameMeRepository renameMeDao;
	
	@Transactional(readOnly = true)
	public RenameMe findByName(String name) {
		return renameMeDao.findByName(name);
	}

	
}
