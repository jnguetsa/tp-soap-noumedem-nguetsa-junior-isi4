package soap.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soap.backend.dto.UtilisateurResponse;
import soap.backend.entity.Utilisateur;
import soap.backend.mapper.AccountMapper;
import soap.backend.service.UtilisateurService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final AccountMapper mapper;

    @PostMapping
    public UtilisateurResponse ajouter(@RequestBody Utilisateur utilisateur) {
        return mapper.toUtilisateurResponse(utilisateurService.ajouter(utilisateur));
    }

    @GetMapping
    public List<UtilisateurResponse> lister() {
        return utilisateurService.lister().stream()
                .map(mapper::toUtilisateurResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UtilisateurResponse getById(@PathVariable Long id) {
        return mapper.toUtilisateurResponse(utilisateurService.getById(id));
    }
}
