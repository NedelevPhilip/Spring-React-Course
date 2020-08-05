package com.example.springreactcourse.repositories;

import com.example.springreactcourse.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
    Card findById(int id);
}
