package com.krasnopolskyi.krasnopolskyiforgolovakha.controller;

import com.krasnopolskyi.krasnopolskyiforgolovakha.entity.MyNumber;
import com.krasnopolskyi.krasnopolskyiforgolovakha.service.MyNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/count")
@RequiredArgsConstructor
public class MyNumberController {

    private final MyNumberService myNumberService;

    @GetMapping()
    public ResponseEntity<MyNumber> getCount() {
        return new ResponseEntity<>(myNumberService.getCount()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);

    }

    @PostMapping()
    public void saveCount(){
        myNumberService.saveCount();
    }
}


