package soap.backend.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class CompteRequest {
    private String numeroCompte;
    private String typeCompte;
    private Double solde;
}
