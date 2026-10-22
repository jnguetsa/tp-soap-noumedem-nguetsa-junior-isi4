package soap.backend.soap;

import org.springframework.ws.server.endpoint.annotation.*;
import soap.backend.dto.GetCategorieCompteRequest;
import soap.backend.dto.GetCategorieCompteResponse;

@Endpoint
public class CompteSoapEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/compte";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategorieCompteRequest")
    @ResponsePayload
    public GetCategorieCompteResponse getCategorieCompte(@RequestPayload GetCategorieCompteRequest request) {
        GetCategorieCompteResponse response = new GetCategorieCompteResponse();
        double solde = request.getSolde();
        if (solde < 100000) {
            response.setCategorie("STANDARD");
            response.setMessage("Compte standard");
        } else if (solde <= 500000) {
            response.setCategorie("PREMIUM");
            response.setMessage("Compte premium");
        } else {
            response.setCategorie("VIP");
            response.setMessage("Compte VIP");
        }
        return response;
    }
}