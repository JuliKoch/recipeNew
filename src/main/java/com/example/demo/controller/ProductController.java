package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.rows.Form;
import com.example.demo.service.IngredientService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ProductController {


    private final IngredientService ingredientService;
    private final ProductService productService;
    @RequestMapping(value="/seedstartermng", params={"save"})
    public String saveSeedstarter(Form form, final ModelMap model) {

        this.ingredientService.insert(ingredient);
        product.setIngredient(ingredient);
        this.productService.insert(product);
        model.clear();
        return "redirect:/seedstartermng";
    }



    @RequestMapping(value="/seedstartermng", params={"addRow"})
    public String addRow(Product product, Ingredient ingredient) {
        ingredient.getRows().add(new Row());
        return "seedstartermng";
    }


    @RequestMapping(value="/seedstartermng", params={"removeRow"})
    public String removeRow(final SeedStarter seedStarter, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        seedStarter.getRows().remove(rowId.intValue());
        return "seedstartermng";
    }
}
