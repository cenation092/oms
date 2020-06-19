package com.assignment.oms.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String id) {
        super("Could not find employee " + id);
    }
}
