package com.example.springreactcourse.controllers;

import com.example.springreactcourse.model.Column;
import com.example.springreactcourse.repositories.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "column")
public class ColumnController {

    @Autowired
    ColumnRepository columnRepository;

    @PostMapping(path = "all")
    public List<Column> getAllColumns(){
        List<Column> columns = columnRepository.findAll();
        return columns;
    }

    @PostMapping(path = "add")
    public Column addColumn(@RequestParam String title){
        Column column = new Column(title);
        columnRepository.save(column);
        return column;
    }

    @PostMapping(path = "delete")
    public String deleteColumn(@RequestParam String id){
        Column column = columnRepository.findById(Integer.parseInt(id));
        columnRepository.delete(column);
        return "ok";
    }

    @PostMapping(path = "rename")
    public String renameColumn(@RequestParam String id, @RequestParam String title){
        Column column = columnRepository.findById(Integer.parseInt(id));
        column.setTitle(title);
        columnRepository.save(column);
        return "ok";
    }
}
