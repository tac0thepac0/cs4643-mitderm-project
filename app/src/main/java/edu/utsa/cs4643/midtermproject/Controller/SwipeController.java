package edu.utsa.cs4643.midtermproject.Controller;

import java.util.ArrayList;

import edu.utsa.cs4643.midtermproject.Model.Swipe;
import edu.utsa.cs4643.midtermproject.Model.User;

public class SwipeController {
    private User user;
    private ArrayList<Swipe> swipes;

    public SwipeController() {
        swipes = new ArrayList<Swipe>();
    }

    public void addSwipe(Swipe swipe) {
        swipes.add(swipe);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Swipe> getSwipes() {
        return swipes;
    }

}
