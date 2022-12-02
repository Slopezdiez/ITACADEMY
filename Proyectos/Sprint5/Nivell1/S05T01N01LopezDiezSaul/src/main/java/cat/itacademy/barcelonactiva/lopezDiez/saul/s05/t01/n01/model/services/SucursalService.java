package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.services;





import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n01.model.domain.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {

    public List<SucursalDTO> findAllSucursals();

   // public SucursalDTO findSucursalById(Integer id);
   public Optional<SucursalDTO> findSucursalById(Integer id);

    public Sucursal saveSucursal(SucursalDTO sucursalNew);

    public String deleteSucursal(int id);

    public String updateSucursal(SucursalDTO SucursalNew);
}
