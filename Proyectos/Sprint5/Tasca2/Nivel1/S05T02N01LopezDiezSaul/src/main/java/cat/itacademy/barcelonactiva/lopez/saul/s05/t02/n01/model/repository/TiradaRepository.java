package cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.repository;



import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Tirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiradaRepository extends JpaRepository<Tirada, Long>{



    List<Tirada> findByJugador(Jugador jugador);
    List<Tirada> findAll();

    void deleteByJugador(Jugador jugador);
}
