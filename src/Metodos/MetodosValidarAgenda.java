/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ValidarAgenda
 * [ValidarAgenda]<br>
 * USAGE:
 * <pre>
 *        MetodosValidarAgenda client = new MetodosValidarAgenda();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author janto
 */
public class MetodosValidarAgenda {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/AgendaRest/webresources";

    public MetodosValidarAgenda() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("ValidarAgenda");
    }

    public String putXml() throws ClientErrorException {
        return webTarget.request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
