package guest;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    int id;
    int userId;
    private String text;
    private int status; //0-не выполнен, 1-важное, 2-выполнен
    private Date creationDate;

    // Constructors:
    public Task() {
    }

    public Task(int userId, String text) {
        this.userId = userId;
        this.text = text;
        this.status = 0;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public Date getDate() {
        return creationDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + userId + " " + text + " status: " + status + " creation: " + creationDate;
    }
}
