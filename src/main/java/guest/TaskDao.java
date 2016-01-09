package guest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskDao {
    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Task task) {
        em.persist(task);
    }

    // Retrieves all the guests:
    public List<Task> getAllTasks() {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t ORDER BY t.id", Task.class);
        return query.getResultList();
    }

    public Task findById(int id) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE t.id = :id", Task.class);
        List<Task> tasks = query.setParameter("id", id).getResultList();
        if (tasks.size() == 0) {
            return null;
        } else {
            return tasks.get(0);
        }
    }
}
