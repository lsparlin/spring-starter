package rename.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import rename.model.RenameMe;

@Transactional
public class CreateTestData {

    public CreateTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        try {
            for (int i = 1; i <= 5; i++) {
                RenameMe renameMe = new RenameMe();
                renameMe.setName("Name " + i);
                session.save(renameMe);
            }
        } catch (Exception e) {

        } finally {
            session.flush();
            session.close();
        }
    }

}
