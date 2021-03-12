package cz.educanet.logreg;

import java.util.UUID;

public class UserToken {
    String body;

    public UserToken(String body) {
        this.body = body;
    }

    public UserToken(){
        this.body = UUID.randomUUID().toString();

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
