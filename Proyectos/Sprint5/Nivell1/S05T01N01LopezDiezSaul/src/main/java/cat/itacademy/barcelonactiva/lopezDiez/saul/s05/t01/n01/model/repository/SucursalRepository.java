package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.repository;



import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {
    //List<Sucursal> findByNom(String nom);



}
