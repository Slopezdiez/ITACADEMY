package S05T02N01LopezDiezSaulFase2.controllers;



import S05T02N01LopezDiezSaulFase2.model.domain.Jugador;
import S05T02N01LopezDiezSaulFase2.model.domain.JugadorDTO;
import S05T02N01LopezDiezSaulFase2.model.domain.Tirada;
import S05T02N01LopezDiezSaulFase2.model.services.JuegoDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/juego")
public class JuegoDadosController {


    @Autowired
    JuegoDadosService juegoDadosService;

    public JuegoDadosController() {
    }

    //            POST: /players: crea un jugador/a.
    @PostMapping("/players")
//public ResponseEntity<Jugador> registrarJugador(@RequestParam(required = false) String nombre) {
    public ResponseEntity<Jugador> registrarJugador(@RequestBody(required = false) Jugador jugador) {
    /*if (nombre == null) {
        nombre = "ANÓNIMO";
    }*/
        if (jugador == null) {
            Jugador jugadorAnonimo = new Jugador("ANÓNIMO");
            return ResponseEntity.status(HttpStatus.CREATED).body(juegoDadosService.registrarJugador(jugadorAnonimo));
        }
        //Jugador jugador = new Jugador(nombre);
        return ResponseEntity.status(HttpStatus.CREATED).body(juegoDadosService.registrarJugador(jugador));
    }


//            PUT /players: modifica el nom del jugador/a.

    @PutMapping("/players")
    public ResponseEntity<?> updateSucursal(@RequestBody Jugador jugador) {

        Optional<Jugador> jugadorDatos = juegoDadosService.findJugadorById(jugador.getId()).stream().findFirst();
        if (jugadorDatos.isPresent()) {
            Jugador _jugador = jugadorDatos.get();
            _jugador.setNombre(jugador.getNombre());

            return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.modificaNombreJugador(_jugador));

        } else {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existeix aquest jugador");
        }
    }

//            POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.

    @PostMapping("/players/{id}/games")
    public ResponseEntity<Tirada> realizarTirada(@PathVariable("id") String id) {
        Optional<Jugador> jugadorDatos = juegoDadosService.findJugadorById(id).stream().findFirst();
        if (jugadorDatos.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.realizarTirada(jugadorDatos.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //            DELETE /players/{id}/games: elimina les tirades del jugador/a.
    @Transactional
    @DeleteMapping("/players/{id}/games")
    public ResponseEntity<?> eliminarTiradas(@PathVariable String id) {
        Optional<Jugador> jugadorDatos = juegoDadosService.findJugadorById(id).stream().findFirst();
        if (jugadorDatos.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.eliminarTiradas(jugadorDatos.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //            GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.
    @GetMapping("/players")
    public ResponseEntity<?> getAllPlayersWithWins() {
        try {
            List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();

            juegoDadosService.verJugadoresConMediaExito().forEach(jugadores::add);

            if (jugadores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sense resultats a la cerca");
            }

            return ResponseEntity.status(HttpStatus.OK).body(jugadores);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//            GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.

    @GetMapping("players/{id}/games")
    public ResponseEntity<?> getAllGamesByPlayer(@PathVariable String id) {
        Optional<Jugador> jugadorDatos = juegoDadosService.findJugadorById(id).stream().findFirst();
        if (jugadorDatos.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.verTiradas(jugadorDatos.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//            GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits.

    @GetMapping("players/ranking")
    public ResponseEntity<?> getMediumScore() {
        return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.porcentajeMedioExito());
    }

    //            GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.
    @GetMapping("players/ranking/loser")
    public ResponseEntity<?> getLowerScore() {
        return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.peorPorcentajeExito());
    }


//            GET /players/ranking/winner: retorna el  jugador amb millor percentatge d’èxit.

    @GetMapping("players/ranking/winner")
    public ResponseEntity<?> getHighestScore() {
        return ResponseEntity.status(HttpStatus.OK).body(juegoDadosService.mejorPorcentajeExito());
    }


}


