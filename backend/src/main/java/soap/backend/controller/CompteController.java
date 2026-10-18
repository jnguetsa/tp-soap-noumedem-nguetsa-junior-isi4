package soap.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soap.backend.dto.CompteResponse;
import soap.backend.entity.Compte;
import soap.backend.mapper.AccountMapper;
import soap.backend.service.CompteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {

    private final CompteService compteService;
    private final AccountMapper mapper;

    @PostMapping("/utilisateur/{utilisateurId}")
    public CompteResponse ajouterCompte(@PathVariable Long utilisateurId, @RequestBody Compte compte) {
        return mapper.toCompteResponse(compteService.ajouterCompte(utilisateurId, compte));
    }

    @GetMapping
    public List<CompteResponse> listerTous() {
        return compteService.listerTous().stream()
                .map(mapper::toCompteResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CompteResponse getById(@PathVariable Long id) {
        return mapper.toCompteResponse(compteService.getById(id));
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<CompteResponse> listerParUtilisateur(@PathVariable Long utilisateurId) {
        return compteService.listerParUtilisateur(utilisateurId).stream()
                .map(mapper::toCompteResponse)
                .collect(Collectors.toList());
    }
}
