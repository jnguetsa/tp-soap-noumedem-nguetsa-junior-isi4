package soap.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soap.backend.entity.Compte;
import soap.backend.entity.Utilisateur;

import java.util.List;
@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

    List<Compte> findByUtilisateurId(Long utilisateurId);
    }

