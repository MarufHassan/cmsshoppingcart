package com.marufhassan.cmsshoppingcart;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.marufhassan.cmsshoppingcart.models.Cart;
import com.marufhassan.cmsshoppingcart.models.CategoryRepository;
import com.marufhassan.cmsshoppingcart.models.PageRepository;
import com.marufhassan.cmsshoppingcart.models.data.Category;
import com.marufhassan.cmsshoppingcart.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@SuppressWarnings("unchecked")
public class Common {
    @Autowired
    private PageRepository pageRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @ModelAttribute
    public void sharedData(Model model, HttpSession session, Principal principal) {
        if (principal != null) {
            model.addAttribute("principal", principal.getName());
        }

        List<Page> pages = pageRepo.findAllByOrderBySortingAsc();
        List<Category> categories = categoryRepo.findAllByOrderBySortingAsc();

        boolean cartActive = false;
        if (session.getAttribute("cart") != null) {
            Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
            int size = 0;
            double total = 0;

            for (Cart value : cart.values()) {
                size += value.getQuantity();
                total += value.getQuantity() * Double.parseDouble(value.getPrice());
            }

            model.addAttribute("csize", size);
            model.addAttribute("ctotal", total);

            cartActive = true;
        }

        model.addAttribute("cpages", pages);
        model.addAttribute("ccategories", categories);
        model.addAttribute("cartActive", cartActive);
    }
}
