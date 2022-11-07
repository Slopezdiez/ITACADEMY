package cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.services;


import cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.LopezDiez.Saul.s04.t02.n02.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaServiceImpl implements FruitaService {

    @Autowired
    FruitaRepository fruitaRepository;

    @Override
    public List<Fruita> findAllFruits() {
        return fruitaRepository.findAll();
    }

    @Override
    public Optional<Fruita> findFruitById(Long id) {
        if (fruitaRepository.findById(id).isPresent()) {
            return fruitaRepository.findById(id);
        }
       return Optional.empty();
    }

    @Override
    public Fruita saveFruita(Fruita fruitaNew) {
        if (fruitaNew !=null) {
            return fruitaRepository.save(fruitaNew);
        }

        return new Fruita();

    }

    @Override
    public String deleteFruita(Long id) {
        if (fruitaRepository.findById(id).isPresent()) {
            fruitaRepository.deleteById(id);
            return "Fruita eliminada correctament.";
        }
        return "Error! La fruita no existeix";
    }

    @Override
    public String updateFruita(Fruita fruitaUpdated) {
        Long num = fruitaUpdated.getId();
        if (fruitaRepository.findById(num).isPresent()) {
            Fruita fruitaToUpdate=new Fruita();
            fruitaToUpdate.setId(fruitaUpdated.getId());
            fruitaToUpdate.setNom(fruitaUpdated.getNom());
            fruitaToUpdate.setQuantitatQuilos(fruitaUpdated.getQuantitatQuilos());
            fruitaRepository.save(fruitaToUpdate);
            return "Fruita modificada";
        }
        return "Fruita no ha pogut ser modificada";
    }
}
