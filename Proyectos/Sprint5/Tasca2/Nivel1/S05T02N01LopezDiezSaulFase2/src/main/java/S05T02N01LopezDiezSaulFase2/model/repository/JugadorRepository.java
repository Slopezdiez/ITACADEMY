package S05T02N01LopezDiezSaulFase2.model.repository;



import S05T02N01LopezDiezSaulFase2.model.domain.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface JugadorRepository extends MongoRepository<Jugador, Long> {
    Optional<Jugador> findById(String num);

    User findByUsername(String username);
}
