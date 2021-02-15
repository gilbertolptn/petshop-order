package com.example.petshop.order.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:petshop-account:29091")
@TestPropertySource(properties = "statusUrl: http://localhost:29091/v1/account/{id}/status")
public class AccountClientIntegrationTest {

    @Autowired
    private AccountClient accountClient;

    @Test
    public void shouldReturnRegularWhenAccountIsOk() {

        assertTrue("Should be Regular", accountClient.isAcountStatusRegular(2L));
    }

    @Test
    public void shouldReturnBlockedWhenAccountIsInDebt() {

        assertFalse("Should be Blocked", accountClient.isAcountStatusRegular(1L));
    }

}