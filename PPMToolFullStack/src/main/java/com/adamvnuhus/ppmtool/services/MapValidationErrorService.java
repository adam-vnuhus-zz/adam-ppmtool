package com.adamvnuhus.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 11/02/2021 - 7:44 AM
 * @created_by anhdt
 * @since 11/02/2021
 */
@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult result) {

        if(result.hasErrors()) {

            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String> >(errorMap, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
