package soap.backend.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "GetCategorieCompteResponse", namespace = "http://example.com/soap/compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCategorieCompteResponse {
    private String categorie;
    private String message;
}