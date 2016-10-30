package zdfapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MediathekService {
    private final String authHeader;
    private final String apiBaseUrl;
    private final Client restClient;

    public MediathekService(String apiToken, String apiBaseUrl) {
        this.authHeader = "Bearer " + apiToken;
        this.apiBaseUrl = apiBaseUrl;

        final DefaultClientConfig conf = new DefaultClientConfig();
        conf.getSingletons().add(new JacksonJsonProvider());
        this.restClient = Client.create(conf);
    }

    public JsonNode get(String path) {
        return restClient.resource(apiBaseUrl + path)
                .header("Api-Auth", authHeader)
                .get(JsonNode.class);
    }
}
