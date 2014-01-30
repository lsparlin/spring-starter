package rename.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rename.model.RenameMe;

public interface RenameMeRepository extends JpaRepository<RenameMe, Integer> {

    RenameMe findByName(String name);
}
