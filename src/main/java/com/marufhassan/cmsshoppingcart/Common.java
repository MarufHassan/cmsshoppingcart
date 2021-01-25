package com.marufhassan.cmsshoppingcart;

import java.util.List;

import com.marufhassan.cmsshoppingcart.models.PageRepository;
import com.marufhassan.cmsshoppingcart.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class Common {
    @Autowired
    private PageRepository pageRepo;

    @ModelAttribute
    public void sharedData(Model model) {
        List<Page> pages = pageRepo.findAllByOrderBySortingAsc();
        model.addAttribute("cpages", pages);

    }
}
