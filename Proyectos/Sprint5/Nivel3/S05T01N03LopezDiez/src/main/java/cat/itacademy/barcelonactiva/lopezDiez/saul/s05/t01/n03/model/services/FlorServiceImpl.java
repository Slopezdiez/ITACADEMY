package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.services;


import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.domain.FlorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService {

    /**
     * The logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(FlorServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
   /* @Autowired
    FlorRepository florRepository;*/

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<FlorDTO> findAllFlors() {

        logger.info("Inicia Busqueda de flores en el Service");
        String uri = "http://localhost:9001/flor/getAll";
        RestTemplate restTemplate = new RestTemplate();
        List<FlorDTO> flors = restTemplate.getForObject(uri, List.class);
        logger.info("Response: {}", flors);
        return flors;
    }

    @Override
    public Optional<FlorDTO> findFlorById(Integer id) {
        logger.info("Inicia Busqueda de la flor id: " + id + " en el Service");
        String uri = "http://localhost:9001/flor/getOne/" + id;
        RestTemplate restTemplate = new RestTemplate();

        try {

            Optional<Flor> flor = restTemplate.getForObject(uri, Optional.class);
            if (flor.isPresent()) {
                FlorDTO florDTO = new FlorDTO(restTemplate.getForObject(uri, Flor.class));
                logger.info("Response: {}", Optional.of(florDTO));
                return Optional.of(florDTO);
            } else {
                return Optional.empty();
            }

        } catch (Exception e) {
            logger.info("Excepcion :" + e);
        }
        return Optional.empty();

    }

    @Override
    public Flor saveFlor(FlorDTO florNew) {
        logger.info("Inicia grabacion de la flor: " + florNew + " en el Service");
        String uri = "http://localhost:9001/flor/add/";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject florJsonObject = new JSONObject();
        florJsonObject.put("pk_FlorID", florNew.getPk_FlorID());
        florJsonObject.put("nomFlor", florNew.getNomFlor());
        florJsonObject.put("paisFlor", florNew.getPaisFlor());
        logger.info("JSON: " + florJsonObject.toString());

        HttpEntity<String> request = new HttpEntity<String>(florJsonObject.toString(), headers);
        restTemplate.postForObject(uri, request, Flor.class);


        return new Flor(florNew.getPk_FlorID(), florNew.getNomFlor(), florNew.getPaisFlor());

    }

    @Override
    public String deleteFlor(int id) {
        logger.info("Inicia update de la flor: " + id + " en el Service");
        if (findFlorById(id).isEmpty()) {
            return "Flor no s'ha trobat";
        } else {
            String uri = "http://localhost:9001/flor/delete/"+id;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(uri);
            return "Esborrada";

        }


    }

    @Override
    public String updateFlor(FlorDTO FlorUpdated) {
        logger.info("Inicia update de la flor: " + FlorUpdated + " en el Service");
        if (findFlorById(FlorUpdated.getPk_FlorID()).isEmpty()) {
            return "Flor no s'ha trobat";
        } else {


            String uri = "http://localhost:9001/flor/update/";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            /*JSONObject florJsonObject = new JSONObject();
            florJsonObject.put("pk_FlorID", FlorUpdated.getPk_FlorID());
            florJsonObject.put("nomFlor", FlorUpdated.getNomFlor());
            florJsonObject.put("paisFlor", FlorUpdated.getPaisFlor());
            logger.info("JSON: " + florJsonObject.toString());*/

            HttpEntity<FlorDTO> request = new HttpEntity<FlorDTO>(FlorUpdated, headers);
            restTemplate.exchange(uri, HttpMethod.PUT, request, Void.class);

            return "Modificada";

        }


    }
}
