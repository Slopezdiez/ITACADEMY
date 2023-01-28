package cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.services;


import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.JugadorDTO;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Tirada;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.repository.TiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class JuegoDadosServiceImpl implements JuegoDadosService {

    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    TiradaRepository tiradaRepository;

    public JuegoDadosServiceImpl(JugadorRepository jugadorRepository, TiradaRepository tiradaRepository) {
        this.jugadorRepository = jugadorRepository;
        this.tiradaRepository = tiradaRepository;
    }


    @Override
    public Jugador registrarJugador(Jugador jugadorInput) {
        Jugador jugador = new Jugador();
        jugador.setNombre(jugadorInput.getNombre());
        jugador.setFechaRegistro(LocalDate.now());
        return jugadorRepository.save(jugador);
    }


    @Override
    public String modificaNombreJugador(Jugador jugador) {

        Long num = jugador.getId();
        if (jugadorRepository.findById(num).isPresent()) {
            Jugador jugadorToUpdate = new Jugador();
            jugadorToUpdate.setId(num);
            jugadorToUpdate.setNombre(jugador.getNombre());
            jugadorToUpdate.setFechaRegistro(LocalDate.now());
            jugadorRepository.save(jugadorToUpdate);
            return "Jugador modificado";
        }
        return "Jugador no ha pogut ser modificat";
    }

    @Override
    public String eliminarTiradas(Jugador jugador) {

        Long num = jugador.getId();
        if (jugadorRepository.findById(num).isPresent()) {
            tiradaRepository.deleteByJugador(jugador);
            return "Tiradas jugador "+jugador.getNombre() +" borradas";
        }
        return  "Jugador no ha pogut ser trobat";
    }

    public List<Tirada> verTiradas(Jugador jugador) {
        Long num = jugador.getId();
        if (jugadorRepository.findById(num).isPresent()) {
            return tiradaRepository.findByJugador(jugador);
        }
       ArrayList<Tirada> vacia = new ArrayList<>();
       return vacia;

    }

    @Override
    public Optional<Jugador> findJugadorById(Long id) {
        if (jugadorRepository.findById(id).isPresent()) {
            Optional<Jugador> jugador= jugadorRepository.findById(id);

             return jugador;
        }
        return Optional.empty();
    }


    //JUEGO DADOS

    public Tirada realizarTirada(Jugador jugador) {
        Tirada tirada = new Tirada();
        tirada.setDado1(randomDado());
        tirada.setDado2(randomDado());
        tirada.setJugador(jugador);
        if (tirada.getDado1() + tirada.getDado2()>= 7) {
            tirada.setGano(true);
        } else {
            tirada.setGano(false);
        }
        return tiradaRepository.save(tirada);
    }

    @Override
    public List<JugadorDTO> verJugadoresConMediaExito() {
        List<Jugador> jugadores =jugadorRepository.findAll();
        List<JugadorDTO> jugadoresDTO= new ArrayList<JugadorDTO>();

        jugadores.forEach(x->{
            double media= calcularPorcentajeExito(x);
            JugadorDTO jugadorDTO=new JugadorDTO(x,media);
            jugadoresDTO.add(jugadorDTO);
        });

        return jugadoresDTO;
    }

    @Override
    public Double porcentajeMedioExito() {
      double porcentajeExito;
   List<Tirada> listaTiradas= new ArrayList<Tirada>();
        listaTiradas=tiradaRepository.findAll();
        double exitos =listaTiradas.stream().filter(tirada->tirada.isGano()== true).count();
        double total = listaTiradas.size();
        porcentajeExito = (exitos / total) * 100;
        return Double.valueOf(Math.round(porcentajeExito));

    }

    @Override
    public JugadorDTO peorPorcentajeExito() {
        List<JugadorDTO> jugadores =verJugadoresConMediaExito();
          return  jugadores
                .stream()
                .min(Comparator.comparing(JugadorDTO::getPorcentajeExito))
                .get()
        ;
    }

    @Override
    public JugadorDTO mejorPorcentajeExito() {
        List<JugadorDTO> jugadores =verJugadoresConMediaExito();

        return  jugadores
                .stream()
                .max(Comparator.comparing(JugadorDTO::getPorcentajeExito))
                .get()
                ;
    }


    public double calcularPorcentajeExito(Jugador jugador) {
        List<Tirada> tiradas = tiradaRepository.findByJugador(jugador);
        int numTiradas = tiradas.size();
        int numTiradasGanadas = 0;
        for (Tirada tirada : tiradas) {
            if (tirada.isGano()) {
                numTiradasGanadas++;
            }
        }
        return (double) numTiradasGanadas / numTiradas * 100;
    }


    public double calcularPorcentajeExitoMedio() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        double porcentajeExitoTotal = 0;
        for (Jugador jugador : jugadores) {
            porcentajeExitoTotal += calcularPorcentajeExito(jugador);
        }
        return porcentajeExitoTotal / jugadores.size();
    }

    private int randomDado() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}

