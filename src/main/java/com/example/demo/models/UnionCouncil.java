package com.example.demo.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class UnionCouncil {
    private final StringProperty Id;
    private final IntegerProperty residents;
    private final IntegerProperty residents_online;
    private final IntegerProperty projects;

    public UnionCouncil(StringProperty id, IntegerProperty residents, IntegerProperty residents_online, IntegerProperty projects) {
        Id = id;
        this.residents = residents;
        this.residents_online = residents_online;
        this.projects = projects;
    }


    public StringProperty idProperty() {
        return Id;
    }


    public IntegerProperty residentsProperty() {
        return residents;
    }

    public IntegerProperty residents_onlineProperty() {
        return residents_online;
    }


    public IntegerProperty projectsProperty() {
        return projects;
    }
}
