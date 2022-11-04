package cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t01.n02.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldController {
    @GetMapping("/saluda")
    public String saluda(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
        return String.format("Hola %s!. Estàs executant un projecte Gradle", nom);
    }


    @GetMapping(value={"/saluda2", "/saluda2/{nom}"})
    @ResponseBody
    public String saluda2(@PathVariable Optional<String> nom) {
        if (nom.isPresent()) {
            return String.format("Hola %s!. Estàs executant un projecte Gradle", nom.get());
        } else {
            return "Falta el parametre nom";
        }


    }
}
