package jp.co.who.spring_tutorial.client.resource;

import java.io.Serializable;

public class JsonResource implements Serializable {
    private String user;
    public String getUser() { return this.user;}

    public void setUser(String user) {
        this.user = user;
    }
}
