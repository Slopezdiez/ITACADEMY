package cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.lopezDiez.Saul.s04.t02.n01.model.domain.Fruita;

import java.util.List;
import java.util.Optional;

public interface FruitaService {

    public List<Fruita> findAllFruits();

    public Optional<Fruita> findFruitById(Long id);

    public Fruita saveFruita(Fruita fruitaNew);

    public String deleteFruita(Long id);

    public String updateFruita(Fruita fruitaNew);
}
