package com.example.springreactcourse.controllers;

import com.example.springreactcourse.model.Card;
import com.example.springreactcourse.model.Column;
import com.example.springreactcourse.repositories.CardRepository;
import com.example.springreactcourse.repositories.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "card")
public class CardController {

    @Autowired
    ColumnRepository columnRepository;
    @Autowired
    CardRepository cardRepository;

    @PostMapping(path = "add")
    public Card addCard(@RequestParam String title, @RequestParam String columnId){
        Column column = columnRepository.findById(Integer.parseInt(columnId));
        Card card = new Card(title, column);
        cardRepository.save(card);
        return card;
    }

    @PostMapping(path = "delete")
    public String deleteCard(@RequestParam String id){
        Card card = cardRepository.findById(Integer.parseInt(id));
        cardRepository.delete(card);
        return "ok";
    }

    @PostMapping(path = "descr")
    public String changeDescription(@RequestParam String descr, @RequestParam String id){
        Card card = cardRepository.findById(Integer.parseInt(id));
        card.setDescription(descr);
        cardRepository.save(card);
        return "ok";
    }

    @PostMapping(path = "copy")
    public Card copyCard(@RequestParam String id){
        Card card = cardRepository.findById(Integer.parseInt(id));
        Card newCard = new Card(card);
        cardRepository.save(newCard);
        return newCard;
    }

    @PostMapping(path = "move")
    public Card moveCard(@RequestParam String cardId, @RequestParam String columnId){
        Card card = cardRepository.findById(Integer.parseInt(cardId));
        Column column = columnRepository.findById(Integer.parseInt(columnId));
        card.setColumn(column);
        cardRepository.save(card);
        return card;
    }
}
