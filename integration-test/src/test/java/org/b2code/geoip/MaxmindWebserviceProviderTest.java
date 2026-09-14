package org.b2code.geoip;

import org.b2code.config.MaxmindWebserviceServerConfig;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.keycloak.testframework.annotations.KeycloakIntegrationTest;

/**
 * Exercises the MaxMind web service provider, which requires a MaxMind account:
 * MAXMIND_ACCOUNT_ID and MAXMIND_LICENSE_KEY are passed to the build as secrets.
 * This fork has no such account — production reads the GeoLite2 database file
 * shipped in the Keycloak image — so the test is skipped rather than failed here.
 * Set both secrets on the repository and it runs again on its own.
 */
@EnabledIfEnvironmentVariable(named = "MAXMIND_ACCOUNT_ID", matches = ".+")
@KeycloakIntegrationTest(config = MaxmindWebserviceServerConfig.class)
class MaxmindWebserviceProviderTest extends BaseGeoIpProviderTest {
}
