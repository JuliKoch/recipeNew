package com.example.demo.rows;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FormRepository {

    private List<Form> forms = new ArrayList<Form>();

    public List<Form> getForms() {
        return forms;
    }

    public List<Form> findAll(){
        return forms;
    }

    public void save(Form form) {
        forms.add(form);
    }

    public void delete(Form form){
        forms.remove(form);
    }
}
