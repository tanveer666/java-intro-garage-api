package ee.itcollage.garageapi.controller;

public class Greeting {
    private String name;
    private Integer order;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public Greeting(String name, Integer order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
