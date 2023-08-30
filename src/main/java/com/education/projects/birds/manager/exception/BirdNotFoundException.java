package com.education.projects.birds.manager.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BirdNotFoundException extends Exception{
    Integer birdId;
    public BirdNotFoundException(UUID birdId){
        super("The bird with id=" + birdId + " wasn't found");
    }
}
