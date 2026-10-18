package soap.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soap.backend.entity.Compte;
import soap.backend.entity.Utilisateur;
import soap.backend.repository.CompteRepository;
import soap.backend.repository.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompteService {

    private final CompteRepository compteRepository;
    private final UtilisateurRepository utilisateurRepository;
    public Compte ajouterCompte(Long utilisateurId, Compte compte)
    {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        compte.setUtilisateur(utilisateur);
        return compteRepository.save(compte);
    }
    public List<Compte> listerTous() {
        return compteRepository.findAll();
    }
    public List<Compte> listerParUtilisateur(Long utilisateurId) {
        return compteRepository.findByUtilisateurId(utilisateurId);
    }
    public Compte getById(Long id) {
        return compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }


}
