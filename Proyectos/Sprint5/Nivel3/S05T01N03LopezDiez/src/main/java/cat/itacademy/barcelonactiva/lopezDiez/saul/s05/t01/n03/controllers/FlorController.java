package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.controllers;


import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.domain.FlorDTO;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.services.FlorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9002")
@RestController
@RequestMapping("/flor")
public class FlorController {
    /** The logger. */
    public static final Logger logger = LoggerFactory.getLogger(FlorController.class);
    @Autowired
    FlorService florService;


    @GetMapping(path="/clientFlorsAll",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> getAllFlors() {
        try{
        logger.info("Ingresa a metodo del controller getAllFlors");
        List<FlorDTO> flors = florService.findAllFlors();
            if (flors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sense resultats a la cerca");
            }
        return ResponseEntity.status(HttpStatus.OK).body(flors);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  http://localhost:8080/FlorDTO/add
    @PostMapping("/clientFlorsAdd")
    public ResponseEntity<?> createFlor(@RequestBody FlorDTO flor) {
        logger.info("Ingresa a metodo del controller createFlor");
        return ResponseEntity.status(HttpStatus.CREATED).body( florService.saveFlor(flor));

    }


    //http://localhost:8080/FlorDTO/update
    @PutMapping("/clientFlorsUpdate")
    public ResponseEntity<?> updateFlor(@RequestBody FlorDTO flor) {
        logger.info("Ingresa a metodo del controller updateFlor");
       // Optional<FlorDTO> FlorData = florService.findFlorById(flor.getPk_FlorID()).stream().findFirst();
        Optional<FlorDTO> FlorData = florService.findFlorById(flor.getPk_FlorID()).stream().findFirst();
        if (FlorData.isPresent()) {
            FlorDTO _Flor = FlorData.get();
            _Flor.setNomFlor(flor.getNomFlor());
            _Flor.setPaisFlor(flor.getPaisFlor());
            return ResponseEntity.status(HttpStatus.OK).body( florService.updateFlor(_Flor));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//http://localhost:8080/FlorDTO/delete/{id}
@RequestMapping(value = "/clientFlorsDelete/{id}", method = RequestMethod.DELETE, produces = "application/json")
public ResponseEntity<?> deleteFlor(@PathVariable int id) {
    logger.info("Ingresa a metodo del controller deleteFlor");
    try {
        ;
        return ResponseEntity.status(HttpStatus.OK).body(florService.deleteFlor(id));


    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



    //http://localhost:8080/FlorDTO/getOne/{id}
    @GetMapping("/clientFlorsGetOne/{id}")
    public ResponseEntity<?> getFlorById(@PathVariable("id") int id) {
        logger.info("Ingresa a metodo del controller getFlorById");
        Optional<FlorDTO> FlorlData = florService.findFlorById(id);
        //FlorDTO FlorlData = florService.findFlorById(id);
        if (FlorlData.isPresent()) {
        //if (FlorlData.getPk_FlorID()!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(florService.findFlorById(id));

        } else {
            logger.info("No encontrada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}



