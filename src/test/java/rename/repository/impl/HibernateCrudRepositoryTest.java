package rename.repository.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;
import rename.repository.CrudRepository;

@Transactional
public class HibernateCrudRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    CrudRepository genericRepo;

    @Test
    public void entity_is_saved_and_retreived() {
        RenameMe renameMe = new RenameMe();
        renameMe.setName("Name1");
        genericRepo.save(renameMe);
        List<RenameMe> list = genericRepo.findAll(RenameMe.class);
        assertEquals(1, list.size());
        assertEquals("Name1", list.get(0).getName());
    }

}
