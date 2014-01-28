package rename.service;

import rename.model.RenameMe;

public interface RenameMeService {
	
	RenameMe findByName(String name);
	
}
