package soap.backend.soap;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.stereotype.Component;
import soap.backend.dto.GetCategorieCompteRequest;
import soap.backend.dto.GetCategorieCompteResponse;

@Component
public class CompteSoapClient {
    private final WebServiceTemplate webServiceTemplate;

    public CompteSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public GetCategorieCompteResponse getCategorie(String numeroCompte, Double solde) {
        GetCategorieCompteRequest request = new GetCategorieCompteRequest();
        request.setNumeroCompte(numeroCompte);
        request.setSolde(solde);

        return (GetCategorieCompteResponse) webServiceTemplate
                .marshalSendAndReceive("http://localhost:8080/ws/comptes", request);
    }
}