package soap.backend.mapper;

import org.springframework.stereotype.Component;
import soap.backend.dto.CompteResponse;
import soap.backend.dto.UtilisateurResponse;
import soap.backend.entity.Compte;
import soap.backend.entity.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public CompteResponse toCompteResponse(Compte compte) {
        if (compte == null) return null;
        return CompteResponse.builder()
                .id(compte.getId())
                .numeroCompte(compte.getNumeroCompte())
                .typeCompte(compte.getTypeCompte())
                .solde(compte.getSolde())
                .build();
    }

    public UtilisateurResponse toUtilisateurResponse(Utilisateur utilisateur) {
        if (utilisateur == null) return null;

        List<CompteResponse> compteResponses = new ArrayList<>();
        if (utilisateur.getComptes() != null) {
            compteResponses = utilisateur.getComptes().stream()
                    .map(this::toCompteResponse)
                    .collect(Collectors.toList());
        }

        return UtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .comptes(compteResponses)
                .build();
    }
}
