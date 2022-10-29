package com.technova.genie.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
public class Genie extends User {
    @Column
    private String description;

    @Column
    private boolean available;

    @ManyToOne(optional = true)
    @JoinColumn(name="category_id", nullable=true)
    private Category category;

    @OneToMany(mappedBy = "genie")
    Set<GenieService> genieServiceSet;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategories(Category category) {
        this.category = category;
    }

//    public List<String> getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(List<String> language) {
//        this.language = language;
//    }

    public Set<GenieService> getServices() {
        return genieServiceSet;
    }

    public void setServices(Set<GenieService> genieServiceSet) {
        this.genieServiceSet = genieServiceSet;
    }

}
