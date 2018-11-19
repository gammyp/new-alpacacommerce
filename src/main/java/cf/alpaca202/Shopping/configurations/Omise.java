package cf.alpaca202.Shopping.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cf.alpaca202.Shopping.services.OmiseService;
import co.omise.ClientException;

@Configuration
public class Omise {
  @Value("${omise.key.public}")
  private String omisePublicKey;

  @Value("${omise.key.private}")
  private String omisePrivateKey;

  @Bean
  public OmiseService omiseService() throws ClientException {
    return new OmiseService(omisePublicKey, omisePrivateKey);
  } 
}