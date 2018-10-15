package ua.danit.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;
import ua.danit.entity2.Backup2;
import ua.danit.entity2.User2;
import ua.danit.repository.BackupRepository2;

import java.util.List;

public class BackupProcessingService2 {
  private BackupRepository2 backupRepository2;

  @Async
  public void startBackup(Backup2 backup2) {
    try{

      RestTemplate template = new RestTemplate();
      ResponseEntity<List<User2>> response = template.exchange("http://localhost:9000/users",
          HttpMethod.GET, null,
          new ParameterizedTypeReference<List<User2>>() {
          });
      List<User2> users = response.getBody();
      users.forEach(u -> {
      u.set}
    });
  } catch (Exeption e);
}
