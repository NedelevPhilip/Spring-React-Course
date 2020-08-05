package com.example.springreactcourse.repositories;

import com.example.springreactcourse.model.ChecklistItem;
import org.springframework.data.repository.CrudRepository;

public interface ChecklistItemRepository extends CrudRepository<ChecklistItem, Integer> {
    ChecklistItem findById(int id);
}
