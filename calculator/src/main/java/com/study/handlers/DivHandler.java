package com.study.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DivHandler {

    public ResponseEntity handle(String var_1, String var_2) {
        try {
            Double num_1 = Double.valueOf(var_1);
            Double num_2 = Double.valueOf(var_2);
            if (num_2 == 0) {
                if (num_1 > 0) {
                    throw new ArithmeticException("+inf");
                } else if (num_1 == 0) {
                    throw new ArithmeticException("type uncertainty 0/0");
                } else {
                    throw new ArithmeticException("-inf");
                }
            }
            Double result = num_1 / num_2;
            return ResponseEntity.ok(result.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
