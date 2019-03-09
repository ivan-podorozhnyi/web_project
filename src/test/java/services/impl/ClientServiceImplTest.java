package services.impl;

import dao.ClientDao;
import domain.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.ClientService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class ClientServiceImplTest {

    private ClientService clientService;
    private ClientDao clientDao = Mockito.mock(ClientDao.class);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        clientService = new ClientServiceImpl(clientDao);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCreateClientFull() {
        //GIVEN
        String name = "full";
        String surName = "name";
        int age = 10;
        String phone = "1234567890";
        String email = "full@full.com";
        String expectedOutput = "Client full name was created";
        Client client = new Client(name, surName, age, phone, email);

        when(clientDao.createClient(client)).thenReturn(true);

        //WNEN
        clientService.createClient(name, surName, phone, age, email);

        //THEN
        Mockito.verify(clientDao).createClient(client);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testCreateClientPartial() {
        //GIVEN
        String name = "partial";
        String surName = "name";
        String phone = "1234567890";
        String expectedOutput = "Client partial name was created";
        Client client = new Client(name, surName, phone);

        when(clientDao.createClient(client)).thenReturn(true);

        //WNEN
        clientService.createClient(name, surName, phone);

        //THEN
        Mockito.verify(clientDao).createClient(client);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testGetClientById() {
        //GIVEN
        int id = 1;
        String name = "test";
        String surName = "test";
        int age = 10;
        String phone = "1234567890";
        String email = "test@test.com";
        Client expectedClient = new Client(name, surName, age, phone, email);

        Mockito.when(clientDao.getClientById(id)).thenReturn(expectedClient);

        //WNEN
        Client client = clientService.getClientById(id);

        //THEN
        Mockito.verify(clientDao).getClientById(1);
        Mockito.verifyNoMoreInteractions(clientDao);
        Assert.assertEquals(expectedClient, client);
    }

    @Test
    public void testEditClientFull() {
        //GIVEN
        int id = 1;
        String name = "full";
        String surName = "update";
        int age = 20;
        String phone = "1234567899";
        String email = "update@update.com";
        String expectedOutput = "Client with id #1 was updated";

        Mockito.when(clientDao.editClient(id, name, surName, phone, age, email)).thenReturn(true);

        //WNEN
        clientService.editClient(id, name, surName, phone, age, email);

        //THEN
        Mockito.verify(clientDao).editClient(id, name, surName, phone, age, email);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testEditClientPartial() {
        //GIVEN
        int id = 2;
        String name = "partial";
        String surName = "update";
        String phone = "1234567899";
        String expectedOutput = "Client with id #2 was updated";

        Mockito.when(clientDao.editClient(id, name, surName, phone, 0, null)).thenReturn(true);

        //WNEN
        clientService.editClient(id, name, surName, phone);

        //THEN
        Mockito.verify(clientDao).editClient(id, name, surName, phone, 0, null);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testRemoveClient() {
        //GIVEN
        int id = 2;
        String expectedOutput = "Client with id #2 was removed";

        Mockito.when(clientDao.removeClient(id)).thenReturn(true);

        //WNEN
        clientService.removeClient(id);

        //THEN
        Mockito.verify(clientDao).removeClient(id);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testGetAllClients() {
        //GIVEN
        String name = "test";
        String surName = "test";
        int age = 10;
        String phone = "1234567890";
        String email = "test@test.com";
        Client client = new Client(name, surName, age, phone, email);

        List<Client> ecpectedClientList = new ArrayList<>();
        ecpectedClientList.add(client);
        Mockito.when(clientDao.getAllClients()).thenReturn(ecpectedClientList);
        //WNEN
        List<Client> clients = clientService.getAllClients();
        //THEN
        Mockito.verify(clientDao).getAllClients();
        Mockito.verifyNoMoreInteractions(clientDao);
        Assert.assertEquals(ecpectedClientList, clients);
    }

    @Test
    public void testNegativeCreateClient() {
        String name = "negative";
        String surName = "name";
        int age = 150;
        String phone = "1234567890";
        String email = "negative@negative.com";
        String expectedOutput = "Could not create client negative name";
        Client client = new Client(name, surName, age, phone, email);

        when(clientDao.createClient(client)).thenReturn(false);

        //WNEN
        clientService.createClient(name, surName, phone, age, email);

        //THEN
        Mockito.verify(clientDao).createClient(client);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testNegativeEditClientById() {
        //GIVEN
        int id = -1;
        String name = "negative";
        String surName = "update";
        int age = 20;
        String phone = "1234567899";
        String email = "negative@update.com";
        String expectedOutput = "Could not update client with id -1";

        Mockito.when(clientDao.editClient(id, name, surName, phone, age, email)).thenReturn(false);

        //WNEN
        clientService.editClient(id, name, surName, phone, age, email);

        //THEN
        Mockito.verify(clientDao).editClient(id, name, surName, phone, age, email);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testNegativeRemoveClientById() {
        //GIVEN
        int id = 0;
        String expectedOutput = "Could not remove client with id 0";

        Mockito.when(clientDao.removeClient(id)).thenReturn(false);

        //WNEN
        clientService.removeClient(id);

        //THEN
        Mockito.verify(clientDao).removeClient(id);
        Mockito.verifyNoMoreInteractions(clientDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @After
    public void tearDown() {
        clientService = null;
        System.setOut(originalOut);
    }


}