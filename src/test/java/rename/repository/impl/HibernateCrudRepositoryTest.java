package rename.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;
import rename.repository.CrudRepository;

/*
 * This test assumes CreateTestData.java inserted some records when the context was built 
 */

@Transactional
public class HibernateCrudRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    CrudRepository crudRepo;

    @Test
    public void testGetById() {
        RenameMe renameMe = crudRepo.getById(RenameMe.class, 1L);
        assertNotNull(renameMe);
        assertEquals("Name 1", renameMe.getName());
    }

    @Test
    public void testFindAll() {
        List<RenameMe> list = crudRepo.findAll(RenameMe.class);
        assertEquals(5, list.size());
    }

    @Test
    public void testDelete() {
        int count = crudRepo.findAll(RenameMe.class).size();
        RenameMe renameMe = crudRepo.getById(RenameMe.class, 1L);
        crudRepo.delete(renameMe);
        assertEquals(count - 1, crudRepo.findAll(RenameMe.class).size());
    }

    @Test
    public void testSave() {
        int count = crudRepo.findAll(RenameMe.class).size();
        RenameMe renameMe = new RenameMe();
        renameMe.setName("New Name");
        crudRepo.save(renameMe);

        assertEquals(count + 1, crudRepo.findAll(RenameMe.class).size());
    }

}
