package rename.repository;

import rename.model.RenameMe;

public interface RenameMeRepository {

    RenameMe findByName(String name);

}
