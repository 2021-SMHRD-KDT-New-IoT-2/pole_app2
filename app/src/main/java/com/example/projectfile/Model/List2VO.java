package com.example.projectfile.Model;

public class List2VO {
    private String id;
    private String location;
    private String transformers;
    private String manager;

    public List2VO(String id, String location, String transformers, String manager) {
        this.id = id;
        this.location = location;
        this.transformers = transformers;
        this.manager = manager;
    }

    public List2VO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransformers() {
        return transformers;
    }

    public void setTransformers(String transformers) {
        this.transformers = transformers;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "List2VO{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", transformers='" + transformers + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
