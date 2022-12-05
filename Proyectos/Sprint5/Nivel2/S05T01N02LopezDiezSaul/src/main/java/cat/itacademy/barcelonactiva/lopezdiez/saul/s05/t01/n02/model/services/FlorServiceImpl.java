package cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.services;



import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.FlorDTO;
import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService {

    @Autowired
    FlorRepository florRepository;

    @Override
    public List<FlorDTO> findAllFlors() {
        List<Flor> flors = florRepository.findAll();
        List<FlorDTO> florsDto = new ArrayList<>();

        flors.stream().forEach(x -> {
            FlorDTO s = new FlorDTO(x);
            florsDto.add(s);
        });
        return florsDto;
    }

    @Override
    public Optional<FlorDTO> findFlorById(Integer id) {
        if (florRepository.findById(id).isPresent()) {
            Optional<Flor> flor= florRepository.findById(id);
            FlorDTO s= new FlorDTO(flor.get());
           // return s;
            return Optional.of(s);
        }
       // return new FlorDTO();
        return Optional.empty();
    }

    @Override
    public Flor saveFlor(FlorDTO florNew) {
        if (florNew != null) {
            Flor flor= new Flor(florNew.getPk_FlorID(), florNew.getNomFlor(), florNew.getPaisFlor());
            return florRepository.save(flor);
        }

        return new Flor();

    }

    @Override
    public String deleteFlor(int id) {
        if (florRepository.findById(id).isPresent()) {
            florRepository.deleteById(id);
            return "Flor eliminada correctament.";
        }
        return "Error! La Flor no existeix";
    }

    @Override
    public String updateFlor(FlorDTO FlorUpdated) {
        int num = FlorUpdated.getPk_FlorID();
        if (florRepository.findById(num).isPresent()) {
            Flor FlorToUpdate = new Flor();
            FlorToUpdate.setPk_FlorID(FlorUpdated.getPk_FlorID());
            FlorToUpdate.setNomFlor(FlorUpdated.getNomFlor());
            FlorToUpdate.setPaisFlor(FlorUpdated.getPaisFlor());
            florRepository.save(FlorToUpdate);
            return "Flor modificada";
        }
        return "Flor no ha pogut ser modificada";
    }
}
