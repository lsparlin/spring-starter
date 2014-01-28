package rename.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rename.dao.RenameMeDao;
import rename.model.RenameMe;

@Repository
public class RenameMeDaoImpl implements RenameMeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public RenameMe get(Long id) {
        return (RenameMe) sessionFactory.getCurrentSession().get(RenameMe.class, id);
    }

    public void delete(RenameMe renameMe) {
        sessionFactory.getCurrentSession().delete(renameMe);
    }

    @SuppressWarnings("unchecked")
    public List<RenameMe> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM RenameMe ORDER BY id").list();
    }

    public void save(RenameMe renameMe) {
        sessionFactory.getCurrentSession().merge(renameMe);

    }

    @Override
    public RenameMe findByName(String name) {
        return (RenameMe) sessionFactory.getCurrentSession().createQuery("FROM RenameMe r WHERE r.name = :name ")
                .setString("name", name).uniqueResult();
    }

}
