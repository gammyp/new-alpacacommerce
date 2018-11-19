package cf.alpaca202.Shopping.services;

import java.io.IOException;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;

public class OmiseService {

  private Client client;

  public OmiseService(String omisePublicKey, String omisePrivateKey) throws ClientException {
    this.client = new Client(omisePublicKey, omisePrivateKey);
  }

  public void chargeCreditCard(String cardToken, double totalPrice) throws IOException, OmiseException {
    Charge charge = this.client.charges().create(
      new Charge.Create()
        .amount((long)(totalPrice * 100))
        .currency("thb")
        .card(cardToken)
    );
    System.out.printf("created charge: %s", charge.getId());
  }
}