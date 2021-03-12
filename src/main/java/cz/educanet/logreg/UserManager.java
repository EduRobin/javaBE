package cz.educanet.logreg;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

import java.util.Objects;
import java.util.Optional;


@ApplicationScoped
public class UserManager {
    @Inject
    private LoginManager loginManager;

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> dostanJmenos() {
        return userList;
    }

    public boolean create(User user) {
        user.setId(userList.size());
        return userList.add(user);
    }

    public UserToken checkniJmenos(User user) {
        Optional<User> tempUser = userList.stream()
                .filter(u -> u.getJmeno().equals(user.getJmeno()))
                .findFirst();
        if (tempUser.isPresent() && Objects.equals(tempUser.get().getHeslo(), user.getHeslo()))
            return loginManager.createToken();
        return null;
    }

    public User dostanJmenos(int id) {
        return userList.stream()
                .filter(userListStream -> id == userListStream.getID())
                .findAny()
                .orElse(null);
    }

    public boolean odstranJmenos(int id) {
        return userList.remove(id) != null;
    }
}
