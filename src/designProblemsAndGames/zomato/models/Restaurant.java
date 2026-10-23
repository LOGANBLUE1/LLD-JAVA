package designProblemsAndGames.zomato.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loc) {
        location = loc;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}

