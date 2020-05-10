package com.rujirakongsomran.implementretrofit2.Model;

public class People {
    private String name;
    private String job;
    private Integer id;
    private String createdAt;

    public People() {
    }

    public People(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public Integer getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
