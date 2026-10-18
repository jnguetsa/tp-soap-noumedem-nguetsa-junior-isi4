package soap.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soap.backend.entity.Utilisateur;
import soap.backend.repository.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    public Utilisateur ajouter(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    public List<Utilisateur> lister() {
        return utilisateurRepository.findAll();
    }
    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new
                        RuntimeException("Utilisateur introuvable"));
    }
}
