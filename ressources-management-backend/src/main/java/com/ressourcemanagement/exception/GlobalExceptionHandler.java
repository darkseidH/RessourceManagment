package com.ressourcemanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e, RedirectAttributes redirectAttributes) {
        // You can customize the error message as per your requirement
        String errorMessage = "Email already exists. Please use a different email.";
        redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
        return "redirect:/responsable/users/add";
    }
}
