package com.example.demo.rows;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import lombok.Data;

@Data
public class Row {
    private Ingredient ingredient = null;
    private Product product = null;

//
//    public Row() {
//        super();
//    }
//

}
