package S05T02N01LopezDiezSaulFase2.model.services;





import S05T02N01LopezDiezSaulFase2.model.domain.Jugador;
import S05T02N01LopezDiezSaulFase2.model.domain.JugadorDTO;
import S05T02N01LopezDiezSaulFase2.model.domain.Tirada;

import java.util.List;
import java.util.Optional;

//@Service
public interface JuegoDadosService {

    //Jugadores

    Jugador registrarJugador(Jugador jugador);


    String modificaNombreJugador(Jugador jugador);

    String eliminarTiradas(Jugador jugador);

    List<Tirada> verTiradas(Jugador jugador);

    Optional<Jugador> findJugadorById(String id);

//Juego de Dados

    Tirada realizarTirada(Jugador jugador);

    List<JugadorDTO> verJugadoresConMediaExito();

    Double porcentajeMedioExito();

    JugadorDTO peorPorcentajeExito();

    JugadorDTO mejorPorcentajeExito();


}
