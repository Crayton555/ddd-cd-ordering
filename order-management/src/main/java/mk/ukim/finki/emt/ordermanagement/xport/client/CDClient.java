package mk.ukim.finki.emt.ordermanagement.xport.client;

import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.CD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class CDClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CDClient(@Value("${app.cd-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<CD> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/cd").build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<CD>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}