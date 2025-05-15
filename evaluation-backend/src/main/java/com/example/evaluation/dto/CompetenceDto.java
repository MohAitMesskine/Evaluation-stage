package com.example.evaluation.dto;

import java.util.List;

public class CompetenceDto {
    private Long id;
    private String intitule;
    private String note;
    private List<CategorieDto> categories;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<CategorieDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorieDto> categories) {
        this.categories = categories;
    }
}
