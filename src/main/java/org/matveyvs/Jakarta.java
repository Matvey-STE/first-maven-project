package org.matveyvs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jakarta {
    private String version;
    private String description;
    private List<Technology> listOfTechnology;

    @JsonCreator
    public Jakarta(@JsonProperty("version") String version, @JsonProperty("description") String description, @JsonProperty ("technologies") List<Technology> listOfTechnology) {
        this.version = version;
        this.description = description;
        this.listOfTechnology = listOfTechnology;
    }

    public void writeToJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Jakarta readFromJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        Jakarta jakarta;
        try {
            jakarta = objectMapper.readValue(new File(path), Jakarta.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jakarta;
    }
    public void updateTechnology(Technology technology) {
        for (int i = 0; i < listOfTechnology.size(); i++) {
            if (listOfTechnology.get(i).getName().equals(technology.getName())) {
                listOfTechnology.get(i).setDescription(technology.getDescription());
            }
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Technology> getListOfTechnology() {
        return listOfTechnology;
    }

    public void setListOfTechnology(List<Technology> listOfTechnology) {
        this.listOfTechnology = listOfTechnology;
    }

    @Override
    public String toString() {
        return "Jakarta{" +
                "version=" + version +
                ", description='" + description + '\'' +
                ", listOfTechnology=" + listOfTechnology +
                '}';
    }

}
