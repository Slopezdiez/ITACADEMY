package cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.controllers;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    FruitaService fruitaService;

    //http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFruits() {
        try {
            List<Fruita> fruitas = new ArrayList<Fruita>();

            fruitaService.findAllFruits().forEach(fruitas::add);

            if (fruitas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sense resultats a la cerca");
            }
            return ResponseEntity.status(HttpStatus.OK).body(fruitas);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<?> createFruit(@RequestBody Fruita fruita) {

        return ResponseEntity.status(HttpStatus.CREATED).body( fruitaService.saveFruita(fruita));

    }


    //http://localhost:8080/fruita/update
    @PutMapping("/update")
    public ResponseEntity<?> updateFruit(@RequestBody Fruita fruita) {
        Optional<Fruita> fruitaData = fruitaService.findFruitById(fruita.getId()).stream().findFirst();
        if (fruitaData.isPresent()) {
            Fruita _fruita = fruitaData.get();
            _fruita.setNom(fruita.getNom());
            _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
            return ResponseEntity.status(HttpStatus.OK).body( fruitaService.updateFruita(_fruita));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    //http://localhost:8080/fruita/delete/{id}
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deleteFruit(@PathVariable long id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(fruitaService.deleteFruita(id));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //http://localhost:8080/fruita/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById(@PathVariable("id") long id) {
        Optional<Fruita> fruitalData = fruitaService.findFruitById(id);

        if (fruitalData.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(fruitaService.findFruitById(id));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}



