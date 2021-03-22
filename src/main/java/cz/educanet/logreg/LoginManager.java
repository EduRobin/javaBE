package cz.educanet.logreg;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class LoginManager {
    ArrayList<UserToken> validTokens = new ArrayList<>();

    public boolean validate(UserToken token){
        return validTokens.stream().anyMatch(token1 -> token1.body.equals(token.body));
    }
    public boolean validate(String token){
        return validTokens.stream().anyMatch(token1 -> token1.body.equals(token));
    }

    public UserToken createToken(){
        UserToken temp = new UserToken();
        validTokens.add(temp);
        return temp;
    }
}