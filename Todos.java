package com.company;

public class Todos {
    int userId;
    int id;
    String title;
    boolean completed;

    @Override
    public String toString() {
        return "\nTodos{" +"\n"+
                "   userId=" + userId + ",\n"+
                "   id=" + id + ",\n"+
                "   title='" + title + ",\n" +
                "   completed=" + completed + "\n"+
                "}";
    }
}
