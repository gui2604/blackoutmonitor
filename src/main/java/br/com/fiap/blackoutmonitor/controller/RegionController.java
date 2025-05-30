package br.com.fiap.blackoutmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.blackoutmonitor.model.Region;
import br.com.fiap.blackoutmonitor.service.RegionService;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {
	
	@Autowired
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/lookup")
    public Region getRegion(@RequestParam(required = false) String cep,
                            @RequestParam(required = false) String deviceId) {
        return regionService.getOrCreateRegionByCep(cep);
    }
}
