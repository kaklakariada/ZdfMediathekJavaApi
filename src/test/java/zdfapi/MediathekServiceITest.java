package zdfapi;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class MediathekServiceITest {

    private static final String API_TOKEN = "d2726b6c8c655e42b68b0db26131b15b22bd1a32";
    private MediathekService service;

    @Before
    public void setup() {

        service = new MediathekService(API_TOKEN, "https://api.zdf.de");
    }

    @Test
    public void test() {
        final JsonNode node = service.get(
                "/content/documents/drama-im-ewigen-eis-die-verschollene-expedition-des-john-100.json?profile=player");
        assertThat(node, notNullValue());
    }
}
