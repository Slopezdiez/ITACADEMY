package cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.repository;


import cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

}
