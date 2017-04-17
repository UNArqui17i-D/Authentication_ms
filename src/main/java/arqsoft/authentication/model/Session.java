package arqsoft.authentication.model;

import javax.persistence.*;

/**
 * Created by erickvelasco11 on 28/03/2017.
 */

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    private long userId;
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
