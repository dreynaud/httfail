package com.httfail;

import com.codahale.metrics.health.HealthCheckRegistry;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JerseyResourceTest {
    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final HealthCheckRegistry healthChecks = mock(HealthCheckRegistry.class);
    private final HttfailApp application = new HttfailApp();
    private final HttfailConfiguration config = new HttfailConfiguration();

    @Before
    public void setup() throws Exception {
        config.setDefaultStatus(42);
        when(environment.jersey()).thenReturn(jersey);
        when(environment.healthChecks()).thenReturn(healthChecks);
    }

    @Test
    public void runDoesNotThrow() throws Exception {
        application.run(config, environment);
    }

    @Test
    public void testStatusEchoed() throws Exception {
        String theMessage = "some reason";
        HttfailResource resource = new HttfailResource(42, theMessage);

        Response defaultGetResponse = resource.get();
        assertThat(defaultGetResponse.getStatus(), is(42));
        assertThat(defaultGetResponse.getEntity(), is(theMessage));

        Response specificPostResponse = resource.post(405);
        assertThat(specificPostResponse.getStatus(), is(405));
        assertThat(defaultGetResponse.getEntity(), is(theMessage));
    }
}