package cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.model.repository;



import cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface FruitaRepository extends MongoRepository<Fruita,Long> {
    List<Fruita> findByNom(String nom);



}
