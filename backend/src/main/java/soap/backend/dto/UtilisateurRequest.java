package soap.backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurRequest {
    private String nom;
    private String email;
}
