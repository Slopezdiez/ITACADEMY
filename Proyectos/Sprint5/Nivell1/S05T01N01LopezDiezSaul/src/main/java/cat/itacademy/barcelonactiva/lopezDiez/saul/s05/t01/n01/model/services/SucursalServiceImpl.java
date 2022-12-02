package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.services;


import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.SucursalDTO;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> findAllSucursals() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        List<SucursalDTO> sucursalsDto = new ArrayList<>();

        sucursals.stream().forEach(x -> {
            SucursalDTO s = new SucursalDTO(x);
            sucursalsDto.add(s);
        });
        return sucursalsDto;
    }

    @Override
    public Optional<SucursalDTO> findSucursalById(Integer id) {
        if (sucursalRepository.findById(id).isPresent()) {
            Optional<Sucursal> sucursal= sucursalRepository.findById(id);
            SucursalDTO s= new SucursalDTO(sucursal.get());
           // return s;
            return Optional.of(s);
        }
       // return new SucursalDTO();
        return Optional.empty();
    }

    @Override
    public Sucursal saveSucursal(SucursalDTO sucursalNew) {
        if (sucursalNew != null) {
            Sucursal sucursal= new Sucursal(sucursalNew.getPk_SucursalID(), sucursalNew.getNomSucursal(), sucursalNew.getPaisSucursal());
            return sucursalRepository.save(sucursal);
        }

        return new Sucursal();

    }

    @Override
    public String deleteSucursal(int id) {
        if (sucursalRepository.findById(id).isPresent()) {
            sucursalRepository.deleteById(id);
            return "Sucursal eliminada correctament.";
        }
        return "Error! La Sucursal no existeix";
    }

    @Override
    public String updateSucursal(SucursalDTO SucursalUpdated) {
        int num = SucursalUpdated.getPk_SucursalID();
        if (sucursalRepository.findById(num).isPresent()) {
            Sucursal SucursalToUpdate = new Sucursal();
            SucursalToUpdate.setPk_SucursalID(SucursalUpdated.getPk_SucursalID());
            SucursalToUpdate.setNomSucursal(SucursalUpdated.getNomSucursal());
            SucursalToUpdate.setPaisSucursal(SucursalUpdated.getPaisSucursal());
            sucursalRepository.save(SucursalToUpdate);
            return "Sucursal modificada";
        }
        return "Sucursal no ha pogut ser modificada";
    }
}
