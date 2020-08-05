package com.example.springreactcourse.controllers;

import com.example.springreactcourse.model.Card;
import com.example.springreactcourse.model.ChecklistItem;
import com.example.springreactcourse.repositories.CardRepository;
import com.example.springreactcourse.repositories.ChecklistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "checklist")
public class ChecklistItemController {

    @Autowired
    ChecklistItemRepository checklistItemRepository;
    @Autowired
    CardRepository cardRepository;

    @PostMapping(path = "add")
    public ChecklistItem addChecklistItem(@RequestParam String text, @RequestParam String cardId){
        Card card = cardRepository.findById(Integer.parseInt(cardId));
        ChecklistItem checklistItem = new ChecklistItem(text, card);
        checklistItemRepository.save(checklistItem);
        return checklistItem;
    }

    @PostMapping(path = "delete")
    public String deleteChecklistItem(@RequestParam String id){
        ChecklistItem checklistItem = checklistItemRepository.findById(Integer.parseInt(id));
        checklistItemRepository.delete(checklistItem);
        return "ok";
    }

    @PostMapping(path = "check")
    public ChecklistItem checkItem(@RequestParam String id){
        ChecklistItem checklistItem = checklistItemRepository.findById(Integer.parseInt(id));
        checklistItem.setChecked(!checklistItem.isChecked());
        checklistItemRepository.save(checklistItem);
        return checklistItem;
    }
}
