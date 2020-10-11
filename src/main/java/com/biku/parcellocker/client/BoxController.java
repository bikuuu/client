package com.biku.parcellocker.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("changestate")
//    @Transactional
    public ResponseEntity<Box> changeState(@RequestBody Box box) {
        //find by name
        Optional<Box> boxByBoxNumber = boxRepository.findBoxByBoxNumber(box.getBoxNumber());
        if (boxByBoxNumber.isPresent()) {
            Box boxFromDb = boxByBoxNumber.get();
            boxFromDb.setStateOpen(box.isStateOpen());
            boxRepository.save(boxFromDb); // jeżeli nie ma @Transactional
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(boxFromDb);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(box);
        }
    }
}
