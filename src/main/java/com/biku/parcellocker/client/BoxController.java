package com.biku.parcellocker.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parcellocker")
public class BoxController {
    private final BoxRepository boxRepository;

    //POST - dodaj nową skrzynkę
    @PostMapping("/addbox")
    public Box addBox(@RequestBody Box box) {
        return boxRepository.save(box);
    }


    //GET
    @GetMapping("/getboxes")
    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }
}
