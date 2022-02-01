package fr.ing.interview.bankaccount.service;

import fr.ing.interview.bankaccount.BankAccountApplication;
import fr.ing.interview.bankaccount.generator.model.TransactionDTO;
import fr.ing.interview.bankaccount.model.Account;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BankAccountApiServiceTest {

    private static final String BASE_PATH = "/ing/bankAccount/Kata";
    public static final String UUID = "aa4a72e0-fa8e-4355-bf42-6c7596d88f63";
    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private HttpEntity<TransactionDTO> transactionDTOHttpEntity;

    @MockBean
    private AccountService accountService;


    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws IOException {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(200.00);
        transactionDTOHttpEntity = new HttpEntity<TransactionDTO>(transactionDTO, headers);

    }


    @Test
    public void displayBalance()  throws IOException{
        //When
        ResponseEntity<BigDecimal> response = restTemplate.
                exchange(createURLWithPort(BASE_PATH+"/bank-account-kata/"+123455+"/accounts"), HttpMethod.GET, transactionDTOHttpEntity, BigDecimal.class);
        //Then
        assertEquals(200,response.getStatusCodeValue());
    }



    @Test
    public void displayTransactions() {
    }

    @Test
    public void withdraw() {
    }

    @Test
    public void shouldreturnStatusOkaywhenCalldeposit_givenRightlimitAmount() {
        Account account = new Account();
        account.setId(UUID);
        when(accountService.retrieve(UUID)).thenReturn(account);
        //When
        ResponseEntity<Boolean> response = restTemplate.exchange(
                createURLWithPort(BASE_PATH+"/bank-account-kata/"+UUID+"/deposit"), HttpMethod.POST, transactionDTOHttpEntity, Boolean.class);
        //Then
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotNull(response.getBody());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
