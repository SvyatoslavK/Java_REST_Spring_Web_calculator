package com.study.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SubHandler {

    public ResponseEntity handle(String var_1, String var_2) {


        try {
            Double num_1 = Double.valueOf(var_1);
            Double num_2 = Double.valueOf(var_2);
            Double result = num_1 - num_2;

            return ResponseEntity.ok(result.toString());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
