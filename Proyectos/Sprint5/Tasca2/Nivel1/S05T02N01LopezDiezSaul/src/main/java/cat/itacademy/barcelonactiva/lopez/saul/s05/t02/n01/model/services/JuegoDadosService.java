package cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.services;



import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.JugadorDTO;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Tirada;

import java.util.List;
import java.util.Optional;

public interface JuegoDadosService {

    //Jugadores

    Jugador registrarJugador(Jugador jugador);


    String modificaNombreJugador(Jugador jugador);

    String eliminarTiradas(Jugador jugador);

    List<Tirada> verTiradas(Jugador jugador);

    Optional<Jugador> findJugadorById(Long id);

//Juego de Dados

    Tirada realizarTirada(Jugador jugador);

    List<JugadorDTO> verJugadoresConMediaExito();

    Double porcentajeMedioExito();

    JugadorDTO peorPorcentajeExito();

    JugadorDTO mejorPorcentajeExito();



}
