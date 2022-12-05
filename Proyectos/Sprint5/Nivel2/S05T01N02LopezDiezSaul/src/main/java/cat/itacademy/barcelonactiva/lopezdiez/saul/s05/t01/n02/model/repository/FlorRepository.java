package cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.repository;





import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor,Integer> {
    //List<Sucursal> findByNom(String nom);



}
