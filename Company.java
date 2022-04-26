package com.company;

public class Company {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    String name;
    String catchPhrase;
    String bs;

    @Override
    public String toString() {
        return "{" +"\n"+
                "    name=" + name + ",\n" +
                "    catchPhrase=" + catchPhrase + ",\n" +
                "    bs=" + bs + "\n"+
                "    }";
    }
}
