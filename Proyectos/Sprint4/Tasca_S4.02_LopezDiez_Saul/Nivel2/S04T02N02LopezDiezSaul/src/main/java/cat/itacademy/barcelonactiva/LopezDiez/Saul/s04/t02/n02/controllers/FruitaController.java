package cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.controllers;


import cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.domain.Fruita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface FruitaController {


    public ResponseEntity<?> getAllFruits();

    public ResponseEntity<?> createFruit(@RequestBody Fruita fruita);


    public ResponseEntity<?> updateFruit(@RequestBody Fruita fruita);


    public ResponseEntity<?> deleteFruit(long id);


    public ResponseEntity<?> getFruitById(@PathVariable("id") long id);



}



