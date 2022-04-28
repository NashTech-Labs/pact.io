package io.openliberty.guides.inventory;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class Inventory {

  private final String url;

  public Inventory(String url) {
    this.url = url;
  }

  public String getServerName() {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url + "/system/properties/key/wlp.server.name")
                              .request()
                              .get();
    String result = response.readEntity(String.class);
    response.close();
    client.close();
    return result;
  }

  public String getEdition() {
    Client client = ClientBuilder.newClient();
    Response response =
             client.target(url + "/system/properties/key/wlp.user.dir.isDefault")
                              .request()
                              .get();
    String result = response.readEntity(String.class);
    response.close();
    client.close();
    return result;
  }

  public String getVersion() {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url + "/system/properties/version")
                              .request()
                              .get();
    String result = response.readEntity(String.class);
    response.close();
    client.close();
    return result;
  }

  public String getInvalidProperty() {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url + "/system/properties/invalidProperty")
                              .request()
                              .get();
    String result = response.readEntity(String.class);
    response.close();
    client.close();
    return result;
  }
}
