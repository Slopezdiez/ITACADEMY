package cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.controllers;



import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.FlorDTO;
import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9001")
@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    FlorService florService;
/*    @Autowired
    private ModelMapper modelMapper;*/

  //  private Model model;

    //http://localhost:8080/FlorDTO/getAll



    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlors() {
        try {
            List<FlorDTO> flors = new ArrayList<FlorDTO>();

            florService.findAllFlors().forEach(flors::add);

            if (flors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sense resultats a la cerca");
            }

            return ResponseEntity.status(HttpStatus.OK).body(flors);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  http://localhost:8080/FlorDTO/add
    @PostMapping("/add")
    public ResponseEntity<?> createFlor(@RequestBody FlorDTO flor) {

        return ResponseEntity.status(HttpStatus.CREATED).body( florService.saveFlor(flor));

    }


    //http://localhost:8080/FlorDTO/update
    @PutMapping("/update")
    public ResponseEntity<?> updateFlor(@RequestBody FlorDTO flor) {
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


/*    //http://localhost:8080/FlorDTO/delete/{id}
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deleteFlor(@PathVariable int id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(florService.deleteFlor(id));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
//http://localhost:8080/FlorDTO/delete/{id}
@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
public ResponseEntity<?> deleteFlor(@PathVariable int id) {
    try {

        return ResponseEntity.status(HttpStatus.OK).body(florService.deleteFlor(id));

    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



    //http://localhost:8080/FlorDTO/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFlorById(@PathVariable("id") int id) {
        Optional<FlorDTO> FlorlData = florService.findFlorById(id);
        //FlorDTO FlorlData = florService.findFlorById(id);
        if (FlorlData.isPresent()) {
        //if (FlorlData.getPk_FlorID()!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(florService.findFlorById(id));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}



