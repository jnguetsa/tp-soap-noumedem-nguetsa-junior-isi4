package soap.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soap.backend.dto.GetCategorieCompteResponse;
import soap.backend.entity.Compte;
import soap.backend.service.CompteService;
import soap.backend.soap.CompteSoapClient;

import java.util.Map;
@RestController
@RequestMapping("/api/soap")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SoapBridgeController {
    private final CompteService compteService;
    private final CompteSoapClient compteSoapClient;
    @GetMapping("/compte/{id}/categorie")
    public Map<String, String> getCategorieCompte(@PathVariable Long
                                                          id) {
        Compte compte = compteService.getById(id);
        GetCategorieCompteResponse response =
                compteSoapClient.getCategorie(compte.getNumeroCompte(),
                        compte.getSolde());
        return Map.of(
                "numeroCompte", compte.getNumeroCompte(),
                "categorie", response.getCategorie(),
                "message", response.getMessage()
        );
    }
}