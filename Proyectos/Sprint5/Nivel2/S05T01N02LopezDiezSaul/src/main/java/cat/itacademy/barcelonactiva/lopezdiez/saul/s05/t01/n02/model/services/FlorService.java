package cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.services;







import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain.FlorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface FlorService {

    public List<FlorDTO> findAllFlors();

   // public FlorDTO findFlorById(Integer id);
   public Optional<FlorDTO> findFlorById(Integer id);

    public Flor saveFlor(FlorDTO florNew);

    public String deleteFlor(int id);

    public String updateFlor(FlorDTO FlorNew);
}
