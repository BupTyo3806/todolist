package guest;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    int id;
    private String name;
    private String password;
    private Date signingDate;
 
    // Constructors:
    public Guest() {
    }
 
    public Guest(String name, String password) {
        this.name = name;
        this.password = password;
        this.signingDate = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return signingDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.signingDate = date;
    }
 
    // String Representation:
    @Override
    public String toString() {
        return id + " " + name + " " + password + " (signed on " + signingDate + ")";
    }
}