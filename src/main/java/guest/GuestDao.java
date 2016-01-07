package guest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GuestDao {
    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }

    // Retrieves all the guests:
    public List<Guest> getAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
                "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
        return query.getResultList();
    }

    public Guest findById(int id) {
        TypedQuery<Guest> query = em.createQuery(
                "SELECT g FROM Guest g WHERE g.id = :id", Guest.class);
        List<Guest> guests = query.setParameter("id", id).getResultList();
        if (guests.size() == 0) {
            return null;
        } else {
            return guests.get(0);
        }
    }

    public Guest findByNameAndPassword(String name, String password) {
        TypedQuery<Guest> query = em.createQuery(
                "SELECT g FROM Guest g WHERE g.name = :name AND g.password = :password", Guest.class);
        List<Guest> guests = query.setParameter("name", name).setParameter("password", password).getResultList();
        if (guests.size() == 0) {
            return null;
        } else {
            return guests.get(0);
        }
    }
}