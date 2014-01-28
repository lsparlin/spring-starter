package rename.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rename.repository.CrudRepository;

@Repository
public class HibernateCrudRepository implements CrudRepository {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> T getById(Class<T> type, Serializable id) {
        return type.cast(sessionFactory.getCurrentSession().get(type, id));
    }

    @Override
    public <T> List<T> findAll(Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    @Override
    public void save(Object entity) {
        sessionFactory.getCurrentSession().merge(entity);
        
    }

    @Override
    public void delete(Object entity) {
        sessionFactory.getCurrentSession().delete(entity);
        
    }

}
