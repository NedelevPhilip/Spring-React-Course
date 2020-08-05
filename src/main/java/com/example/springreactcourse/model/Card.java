package com.example.springreactcourse.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @javax.persistence.Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
    private List<ChecklistItem> checklistItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "column_id")
    private Column column;

    public Card(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChecklistItem> getChecklistItems() {
        return checklistItems;
    }

    public void setChecklistItems(List<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
