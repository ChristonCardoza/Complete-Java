package com.handson.serialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/sd")
public class SDController {

    @Autowired
    SDService sdService;

    @GetMapping("/doSD")
    public ResponseEntity<String> doSD() throws IOException, ClassNotFoundException {

        sdService.doSD();

        return ResponseEntity.ok("Serialize De-Serialize Data Successfully");
    }

    @GetMapping("/objectGraphSD")
    public ResponseEntity<String> objectGraphSD() throws IOException, ClassNotFoundException {

        sdService.objectGraphSD();

        return ResponseEntity.ok("Object Graph Serialize De-Serialize Successfully");
    }

    @GetMapping("/customizeSD")
    public ResponseEntity<String> customizeSD() throws IOException, ClassNotFoundException {

        sdService.customizeSD();

        return ResponseEntity.ok("Customize Serialize De-Serialize Successfully");
    }

    @GetMapping("/inheritanceSD")
    public ResponseEntity<String> inheritanceSD() throws IOException, ClassNotFoundException {

        sdService.inheritanceSD();

        return ResponseEntity.ok("Child Serialize De-Serialize Successfully");
    }

    @GetMapping("/instanceControlFlowSD")
    public ResponseEntity<String> instanceControlFlowSD() throws IOException, ClassNotFoundException {

        sdService.instanceControlSD();

        return ResponseEntity.ok("Child1 Instance Control Flow Serialize De-Serialize Successfully");
    }

    @GetMapping("/externalizationSD")
    public ResponseEntity<String> externalizationSD() throws IOException, ClassNotFoundException {

        sdService.externalizationSD();

        return ResponseEntity.ok("Externalize Serialize De-Serialize Successfully");
    }
}
