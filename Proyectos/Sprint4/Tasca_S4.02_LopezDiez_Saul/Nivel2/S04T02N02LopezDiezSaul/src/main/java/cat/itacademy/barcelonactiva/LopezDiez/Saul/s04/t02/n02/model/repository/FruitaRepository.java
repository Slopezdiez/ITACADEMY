package cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.repository;


import cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitaRepository extends JpaRepository<Fruita,Long> {
    List<Fruita> findByNom(String nom);



}
