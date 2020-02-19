package com.soge.particlesChamber.controller;

import com.google.gson.Gson;
import com.soge.particlesChamber.model.ParticleChamber;
import org.apache.coyote.Response;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
    WebService in charge of the function animate
 */
@ComponentScan
@RestController
public class AnimateWebService {

    @ExceptionHandler(Exception.class)
    @GetMapping("/animate")
    public ResponseEntity animate(@RequestParam("speed") int speed, @RequestParam("init") String init) throws Exception {
        try {
            if( speed < 1 || speed > 10 ) throw new Exception("Speed must be a number between 1 and 10."); // Filter Speed
            if( init.length() < 1 || init.length() > 50 ) throw new Exception("Init length must be between 1 and 50."); // Filter init
            if(! init.matches("([LR.]+)")) throw new Exception("Invalid Characters in init string.");

            // Create the Particle chamber and compute the result
            ParticleChamber particleChamber = new ParticleChamber(speed, init);
            particleChamber.animateChamber();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(particleChamber.printChamber().toString());
        } catch (Exception e) {
            System.out.println("An error occured during the request processing :"+e.getMessage()); // Must be replace by a logger
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
