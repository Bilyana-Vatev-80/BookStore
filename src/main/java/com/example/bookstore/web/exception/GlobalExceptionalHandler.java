package com.example.bookstore.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionalHandler {

    public ModelAndView handleDbExceptions(ObjectNotFoundException e){
        ModelAndView modelAndView = new ModelAndView("errors/object-not-found-error");
        modelAndView.addObject("objectName",e.getObjectName());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
