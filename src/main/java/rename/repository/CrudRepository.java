package rename.repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository {

    <T> T getById(Class<T> type, Serializable id);
    
    <T> List<T> findAll(Class<T> type);
    
    void save(Object entity);
    
    void delete(Object entity);

}
