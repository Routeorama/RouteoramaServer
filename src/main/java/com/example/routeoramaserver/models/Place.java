package com.example.routeoramaserver.models;

import java.io.Serializable;
import java.util.Objects;

public class Place implements Serializable {
    private int id;
    private String name;
    private String description;
    private String nameOfCreator;

    public Place(int id, String name, String description, String nameOfCreator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.nameOfCreator = nameOfCreator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfCreator() {
        return nameOfCreator;
    }

    public void setNameOfCreator(String nameOfCreator) {
        this.nameOfCreator = nameOfCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id && name.equals(place.name) && description.equals(place.description) && nameOfCreator.equals(place.nameOfCreator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, nameOfCreator);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nameOfCreator='" + nameOfCreator + '\'' +
                '}';
    }
}
