package com.study.controllers;

import com.study.handlers.AddHandler;
import com.study.handlers.SubHandler;
import com.study.handlers.DivHandler;
import com.study.handlers.MultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.ws.rs.core.MediaType;

@RestController()
public class CalculationController {

    AddHandler addHandler;
    SubHandler subHandler;
    MultHandler multHandler;
    DivHandler divHandler;
    @Autowired
    public CalculationController(AddHandler addHandler, SubHandler subHandler, DivHandler divHandler, MultHandler multHandler) {
        this.addHandler = addHandler;
        this.divHandler = divHandler;
        this.multHandler = multHandler;
        this.subHandler = subHandler;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<String> add(@RequestParam String var_1, @RequestParam String var_2) {
        return addHandler.handle(var_1, var_2);
    }

    @GetMapping(path = "/sub")
    public ResponseEntity<String> sub(@RequestParam String var_1, @RequestParam String var_2) {
        return subHandler.handle(var_1, var_2);
    }

    @GetMapping(path = "/div")
    public ResponseEntity<String> div(@RequestParam String var_1, @RequestParam String var_2) {
        return divHandler.handle(var_1, var_2);
    }

    @GetMapping(path = "/mult")
    public ResponseEntity<String> mult(@RequestParam String var_1, @RequestParam String var_2) {
        return multHandler.handle(var_1, var_2);
    }
}
