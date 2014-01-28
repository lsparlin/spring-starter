package rename.service;

import java.util.List;

import rename.model.RenameMe;

public interface RenameMeService {
	
	RenameMe get(Long id);
	
	void save(RenameMe renameMe);
	
	void delete(RenameMe renameMe);
	
	List<RenameMe> findAll();
	
	void saveAll(List<RenameMe> list);
	
}
