package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.rows.Form;
import com.example.demo.rows.FormRepository;
import com.example.demo.rows.Row;
import com.example.demo.service.IngredientService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final FormRepository formRepository;
    private final IngredientService ingredientService;
    private final ProductService productService;

//    @RequestMapping(value="/seedstartermng", params={"save"})
//    public String saveSeedstarter(Form form, final ModelMap model) {
//
//        this.ingredientService.insert(ingredient);
//        this.productService.insert(product);
//        product.setIngredient(ingredient);
//        model.clear();
//        return "redirect:/seedstartermng";
//    }



    @RequestMapping(value="/seedstartermng", params={"addRow"})
    public String addRow(Form form) {
        form.getRows().add(new Row());
        return "seedstartermng";
    }


    @RequestMapping(value="/seedstartermng", params={"removeRow"})
    public String removeRow(final Form seedStarter, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        seedStarter.getRows().remove(rowId.intValue());
        return "seedstartermng";
    }
}
