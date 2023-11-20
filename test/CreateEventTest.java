import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EventTest {

    @Mock
    private Client mockClient;

    @Before
    public void setup() {
        // Initialize and inject the mocked Client into your Event class
        mockClient = mock(Client.class);
        event.setClient(mockClient);
    }

    @Test
    public void testCreateEvent() {
        // Prepare test data
        String name = "Test Event";
        String start = "2023-11-06T12:00:00Z";
        String end = "2023-11-06T14:00:00Z";
        String currency = "USD";
        String summary = "Test event summary";
        Boolean isPrivate = false;

        // Mock the response from the external service
        Response mockResponse = mock(Response.class);
        when(mockClient.target(anyString()))
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(eq("Authorization"), eq("Bearer PERSONAL_OAUTH_TOKEN"))
            .post(any(Entity.class))
            .thenReturn(mockResponse);

        // Set up the expected response status and entity (you can customize this based on your test case)
        when(mockResponse.getStatus()).thenReturn(200);
        when(mockResponse.readEntity(String.class)).thenReturn("Event created successfully");

        // Call the create method
        EventFactory eventFactory = new CommonEventFactory(); // Instantiate your Event class
        Event createdEvent = eventFactory.create(name, start, end, currency, summary, isPrivate);

        // Add assertions to verify the behavior
        assertEquals("Event created successfully", createdEvent);
        // You can add more assertions as needed to check the behavior of your code
    }
}
