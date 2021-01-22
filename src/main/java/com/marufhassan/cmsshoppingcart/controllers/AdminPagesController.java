package com.marufhassan.cmsshoppingcart.controllers;

import java.util.List;

import com.marufhassan.cmsshoppingcart.models.PageRepository;
import com.marufhassan.cmsshoppingcart.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/pages")
public class AdminPagesController {
    @Autowired
    private PageRepository pageRepo;

    @GetMapping
    public String index(Model model) {
        List<Page> pages = pageRepo.findAll();
        model.addAttribute("pages", pages);
        return "admin/pages/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute Page page) {
        //model.addAttribute("page", new Page());
        return "admin/pages/add";
    }
}
