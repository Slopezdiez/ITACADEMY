package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.controllers;



import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.SucursalDTO;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.services.SucursalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;
/*    @Autowired
    private ModelMapper modelMapper;*/

  //  private Model model;

    //http://localhost:8080/SucursalDTO/getAll



    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSucursals() {
        try {
            List<SucursalDTO> sucursals = new ArrayList<SucursalDTO>();

            sucursalService.findAllSucursals().forEach(sucursals::add);

            if (sucursals.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sense resultats a la cerca");
            }

            return ResponseEntity.status(HttpStatus.OK).body(sucursals);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  http://localhost:8080/SucursalDTO/add
    @PostMapping("/add")
    public ResponseEntity<?> createSucursal(@RequestBody SucursalDTO sucursal) {

        return ResponseEntity.status(HttpStatus.CREATED).body( sucursalService.saveSucursal(sucursal));

    }


    //http://localhost:8080/SucursalDTO/update
    @PutMapping("/update")
    public ResponseEntity<?> updateSucursal(@RequestBody SucursalDTO sucursal) {
       // Optional<SucursalDTO> SucursalData = sucursalService.findSucursalById(sucursal.getPk_SucursalID()).stream().findFirst();
        Optional<SucursalDTO> SucursalData = sucursalService.findSucursalById(sucursal.getPk_SucursalID()).stream().findFirst();
        if (SucursalData.isPresent()) {
            SucursalDTO _Sucursal = SucursalData.get();
            _Sucursal.setNomSucursal(sucursal.getNomSucursal());
            _Sucursal.setPaisSucursal(sucursal.getPaisSucursal());
            return ResponseEntity.status(HttpStatus.OK).body( sucursalService.updateSucursal(_Sucursal));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //http://localhost:8080/SucursalDTO/delete/{id}
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deleteSucursal(@PathVariable int id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.deleteSucursal(id));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //http://localhost:8080/SucursalDTO/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getSucursalById(@PathVariable("id") int id) {
        Optional<SucursalDTO> SucursallData = sucursalService.findSucursalById(id);
        //SucursalDTO SucursallData = sucursalService.findSucursalById(id);
        if (SucursallData.isPresent()) {
        //if (SucursallData.getPk_SucursalID()!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.findSucursalById(id));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  /*  private SucursalDTO convertToDto(Sucursal sucursal) {
        SucursalDTO sucursalDTO = modelMapper.map(sucursal, SucursalDTO.class);
        sucursalDTO.definirTipusSucursal


        sucursalDTO.setSubmissionDate(sucursal.getSubmissionDate(),
                userService.getCurrentUser().getPreference().getTimezone());
        return sucursalDTO;
    }*/

/*    @RequestMapping(value = "/index")
    public String index(Model modelo) {
        modelo.addAttribute("mensaje", "hola desde thymeleaf");
        return "index";
    }*/
}



