package rename.repository;

import java.util.List;

import rename.model.RenameMe;

public interface RenameMeRepository {

    RenameMe get(Long id);

    void save(RenameMe renameMe);

    void delete(RenameMe renameMe);

    List<RenameMe> findAll();

    RenameMe findByName(String name);

}
