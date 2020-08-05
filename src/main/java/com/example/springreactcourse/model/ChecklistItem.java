package com.example.springreactcourse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "checklist_items")
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private boolean checked;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @JsonIgnoreProperties({"checklistItems"})
    private Card card;

    public ChecklistItem(){}

    public ChecklistItem(String text, Card card) {
        this.text = text;
        this.card = card;
        this.checked = false;
    }

    public ChecklistItem(String text, Card card, boolean checked) {
        this.text = text;
        this.card = card;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
