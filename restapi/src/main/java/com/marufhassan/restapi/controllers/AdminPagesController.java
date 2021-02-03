package com.marufhassan.restapi.controllers;

import java.util.List;
import java.util.Optional;

import com.marufhassan.restapi.models.PageRepository;
import com.marufhassan.restapi.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin/pages", produces = "application/json")
@CrossOrigin(origins = "*")
public class AdminPagesController {
    @Autowired
    private PageRepository pageRepo;    

    @GetMapping("/all")
    public Iterable<Page> pages() {
        List<Page> pages = pageRepo.findAllByOrderBySortingAsc();
        return pages;
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Page add(@RequestBody Page page) {
        return pageRepo.save(page);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Page> edit(@PathVariable int id) {
        Optional<Page> page = pageRepo.findById(id);
        return new ResponseEntity<>(page.get(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public Page put(@RequestBody Page page) {
        return pageRepo.save(page);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        try {
            pageRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            
        }
    }
}
