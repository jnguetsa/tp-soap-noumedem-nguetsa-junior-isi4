package soap.backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompteResponse {
    private Long id;
    private String numeroCompte;
    private String typeCompte;
    private Double solde;
}
