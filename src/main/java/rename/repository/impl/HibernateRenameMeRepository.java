package rename.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rename.model.RenameMe;
import rename.repository.RenameMeRepository;

@Repository
public class HibernateRenameMeRepository implements RenameMeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public RenameMe findByName(String name) {
        return (RenameMe) sessionFactory.getCurrentSession().createQuery("FROM RenameMe r WHERE r.name = :name ")
                .setString("name", name).uniqueResult();
    }

}
