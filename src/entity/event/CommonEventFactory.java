package entity.event;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class CommonEventFactory implements EventFactory {

    @Override
    public Event create(String name, String start, String end, String currency, String summary, Boolean isPrivate) {
        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json("{  \"event\": {    \"name\": {      \"html\": \"&#60;p&#62;" + name + "&#60;/p&#62;\"    },    \"description\": {      \"html\": \"&#60;p&#62;Some text&#60;/p&#62;\"    },    \"start\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"end\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"currency\": \"USD\",    \"online_event\": false,    \"organizer_id\": \"\",    \"listed\": false,    \"shareable\": false,    \"invite_only\": false,    \"show_remaining\": true,    \"password\": \"12345\",    \"capacity\": 100,    \"is_reserved_seating\": true,    \"is_series\": true,    \"show_pick_a_seat\": true,    \"show_seatmap_thumbnail\": true,    \"show_colors_in_seatmap_thumbnail\": true,    \"locale\": \"de_AT\"  }}");
        Response response = client.target("https://www.eventbriteapi.com/v3/organizations/{1861001665463}/events/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Bearer V62FODWQELD5JCBTLNQC")
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));

        return new CommonEvent("0", name, start, end, currency, summary, isPrivate);
    }

    public Event modify(String id, String name, String start, String end, String currency, String summary, Boolean isPrivate) {
        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json("{  \"event\": {    \"name\": {      \"html\": \"&#60;p&#62;Some text&#60;/p&#62;\"    },    \"description\": {      \"html\": \"&#60;p&#62;Some text&#60;/p&#62;\"    },    \"start\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"end\": {      \"timezone\": \"UTC\",      \"utc\": \"2018-05-12T02:00:00Z\"    },    \"currency\": \"USD\",    \"online_event\": false,    \"organizer_id\": \"\",    \"listed\": false,    \"shareable\": false,    \"invite_only\": false,    \"show_remaining\": true,    \"password\": \"12345\",    \"capacity\": 100,    \"is_reserved_seating\": true,    \"is_series\": true,    \"show_pick_a_seat\": true,    \"show_seatmap_thumbnail\": true,    \"show_colors_in_seatmap_thumbnail\": true  }}");
        Response response = client.target("https://www.eventbriteapi.com/v3/events/" + id + "/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Bearer PERSONAL_OAUTH_TOKEN")
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        // TODO: Replace this with the Event retrieved from the data access object
        return new CommonEvent("0", name, start, end, currency, summary, isPrivate);
    }
}
