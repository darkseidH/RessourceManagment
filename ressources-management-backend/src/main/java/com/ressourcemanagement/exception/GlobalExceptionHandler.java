package com.ressourcemanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.AccessDeniedException;
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

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException e, RedirectAttributes redirectAttributes) {
        String errorMessage = "Tu n'as pas le droit d'accéder à cette page";
        redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
        return "redirect:/error";
    }
}
