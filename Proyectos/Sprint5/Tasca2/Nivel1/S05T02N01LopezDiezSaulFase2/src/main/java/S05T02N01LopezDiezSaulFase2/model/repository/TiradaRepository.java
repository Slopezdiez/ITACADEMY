package S05T02N01LopezDiezSaulFase2.model.repository;




import S05T02N01LopezDiezSaulFase2.model.domain.Jugador;
import S05T02N01LopezDiezSaulFase2.model.domain.Tirada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TiradaRepository extends MongoRepository<Tirada, Long> {



    List<Tirada> findByJugador(Jugador jugador);
    List<Tirada> findAll();

    void deleteByJugador(Jugador jugador);
}
