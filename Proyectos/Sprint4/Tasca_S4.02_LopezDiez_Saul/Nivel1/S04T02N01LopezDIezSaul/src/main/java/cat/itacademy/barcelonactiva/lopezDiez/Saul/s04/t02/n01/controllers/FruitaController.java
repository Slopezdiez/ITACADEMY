package cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.model.domain.Fruita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface FruitaController {


    public ResponseEntity<?> getAllFruits();

    public ResponseEntity<?> createFruit(@RequestBody Fruita fruita);


    public ResponseEntity<?> updateFruit(@RequestBody Fruita fruita);


    public ResponseEntity<?> deleteFruit(long id);


    public ResponseEntity<?> getFruitById(@PathVariable("id") long id);


}



