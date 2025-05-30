package br.com.fiap.blackoutmonitor.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.blackoutmonitor.dto.ViaCepResponse;
import br.com.fiap.blackoutmonitor.model.Region;
import br.com.fiap.blackoutmonitor.repository.RegionRepository;



@Service
public class RegionService {

    private static final Logger log = LoggerFactory.getLogger(RegionService.class);

    private final RegionRepository regionRepository;
    private final RestTemplate restTemplate;

    public RegionService(RegionRepository regionRepository, RestTemplate restTemplate) {
        this.regionRepository = regionRepository;
        this.restTemplate = restTemplate;
    }
    
    public static String normalizeCep(String cep) {
    	if (cep == null || cep.trim().isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        }
        return cep.replaceAll("[^0-9]", "");
    }
    
    public Region getOrCreateRegionByCep(String rawCep) {
    	// normalizando o cep para remover caracteres especiais
    	String cep = normalizeCep(rawCep);
    	log.info("\n->"+ cep + "\n");
    	// verifica se o cep existe no banco h2, se existir retorna a resposta
        Optional<Region> existing = regionRepository.findByCep(cep);
        if (existing.isPresent()) {
            log.info("\n-> Região de CEP {} encontrada em cache!\n", cep);
            return existing.get();
        }

        log.info("\n-> Região de CEP {} não encontrada em cache. Consultando ViaCEP...\n", cep);

        // se o cep não existir 
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCepResponse viaCep;
        try {
        	viaCep = restTemplate.getForObject(url, ViaCepResponse.class);
        	
        }catch(HttpClientErrorException e) {
        	if(e.getStatusCode() == HttpStatus.BAD_REQUEST) {
        		throw new IllegalArgumentException("CEP Inválido!");        		
        	}
        	throw new RuntimeException("Erro ao consultar o ViaCEP", e);
        }
        	

        Region region = new Region();
        region.setCep(normalizeCep(viaCep.getCep()));
        region.setStreet(viaCep.getLogradouro());
        region.setNeighborhood(viaCep.getBairro());
        region.setCity(viaCep.getLocalidade());
        region.setState(viaCep.getUf());

        log.info("\n-> CEP {} consultado com sucesso via ViaCEP. Região salva no banco.\n", cep);

        return regionRepository.save(region);
    }
}
