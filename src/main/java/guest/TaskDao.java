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

    @Transactional
    public void persist(Task task) {
        em.persist(task);
    }

    public Task getById(int id) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE t.id = :id", Task.class);
        List<Task> tasks = query.setParameter("id", id).getResultList();
        if (tasks.size() == 0) {
            return null;
        } else {
            return tasks.get(0);
        }
    }

    public List<Task> getAllTasksToRss() {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t ORDER BY t.id", Task.class);
        return query.getResultList();
    }

    public List<Task> getAllTasks(int userId) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE t.userId = :userId OR t.sharing = true ORDER BY t.id", Task.class);
        return query.setParameter("userId", userId).getResultList();
    }

    public List<Task> getNotExecutedTasks(int userId) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE (t.userId = :userId OR t.sharing = true) AND (t.status = 0 OR t.status = 1) ORDER BY t.id", Task.class);
        return query.setParameter("userId", userId).getResultList();
    }

    public List<Task> getExecutedTasks(int userId) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE (t.userId = :userId OR t.sharing = true) AND t.status = 2 ORDER BY t.id", Task.class);
        return query.setParameter("userId", userId).getResultList();
    }

    public List<Task> getImportantTasks(int userId) {
        TypedQuery<Task> query = em.createQuery(
                "SELECT t FROM Task t WHERE (t.userId = :userId OR t.sharing = true) AND t.status = 1 ORDER BY t.id", Task.class);
        return query.setParameter("userId", userId).getResultList();
    }

    @Transactional
    public void changeStatus(int id, int status) {
        TypedQuery<Task> query = em.createQuery(
                "UPDATE Task t SET t.status = :status WHERE t.id = :id", Task.class);
        int updateCount = query.setParameter("id", id).setParameter("status", status).executeUpdate();
    }

    @Transactional
    public void shareTask(int id) {
        TypedQuery<Task> query = em.createQuery(
                "UPDATE Task t SET t.sharing = true WHERE t.id = :id", Task.class);
        int updateCount = query.setParameter("id", id).executeUpdate();
    }

    @Transactional
    public void deleteTask(int id) {
        Task t = em.find(Task.class, id);
        em.remove(t);
    }
}
