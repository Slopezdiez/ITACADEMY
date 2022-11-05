package cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.model.repository.FruitaRepository;
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
    FruitaRepository fruitaRepository;
//http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruits(@RequestParam(required = false) String nom){
        try {
            List<Fruita> fruitas = new ArrayList<Fruita>();
            if (nom == null)
                fruitaRepository.findAll().forEach(fruitas::add);
            else
                fruitaRepository.findByNom(nom).forEach(fruitas::add);

            if (fruitas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruitas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruit(@RequestBody Fruita fruita) {
        try {
            Fruita _fruita = fruitaRepository
                    .save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
            return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//http://localhost:8080/fruita/update
@PutMapping("/update")
public ResponseEntity<Fruita> updateFruit( @RequestBody Fruita fruita) {
    Optional<Fruita> fruitaData = fruitaRepository.findByNom(fruita.getNom()).stream().findFirst();
    if (fruitaData.isPresent()) {
        Fruita _fruita = fruitaData.get();
        _fruita.setNom(fruita.getNom());
        _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
        return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
/*@PutMapping("/fruita/{id}")
public ResponseEntity<Fruita> updateFruit(@PathVariable("id") long id, @RequestBody Fruita fruita) {
    Optional<Fruita> fruitaData = fruitaRepository.findById(id);

    if (fruitaData.isPresent()) {
        Fruita _fruita = fruitaData.get();
        _fruita.setNom(fruita.getNom());
        _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
        return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}*/

    //http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {
        try {
            fruitaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  //http://localhost:8080/fruita/getOne/{id}
  @GetMapping("/getOne/{id}")
  public ResponseEntity<Fruita> getFruitById(@PathVariable("id") long id) {
      Optional<Fruita> frutialData = fruitaRepository.findById(id);

      if (frutialData.isPresent()) {
          return new ResponseEntity<>(frutialData.get(), HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }


}



