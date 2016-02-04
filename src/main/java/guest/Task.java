package guest;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    int id;
    int userId;
    private String userName;
    private String text;
    private int status; //0-не выполнен, 1-важное, 2-выполнен
    private Date creationDate;
    private boolean sharing;

    // Constructors:
    public Task() {
    }

    public Task(int userId, String userName, String text) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.status = 0;
        this.creationDate = new Date(System.currentTimeMillis());
        this.sharing = false;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
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

    public boolean getSharing() {
        return sharing;
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

    public void setSharing(boolean sharing) {
        this.sharing = sharing;
    }

    @Override
    public String toString() {
        return id + " " + userId + " " + text + " status: " + status + " creation: " + creationDate;
    }
}
