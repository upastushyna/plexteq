package ua.danit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.danit.entity.Backup;
import ua.danit.entity.BackupStatus;
import ua.danit.entity.User;
import ua.danit.repository.BackupRepository;
import java.util.List;

@Service
public class BackupProcessingService {
  private BackupRepository backupRepository;

  @Autowired
  public BackupProcessingService(BackupRepository backupRepository) {
    this.backupRepository = backupRepository;
  }

  @Async
  public void startBackup(Backup backup) {
    try {

      RestTemplate template = new RestTemplate();
      ResponseEntity<List<User>> response = template.exchange("http://localhost:9000/users",
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<List<User>>() {
          });
      List<User> users = response.getBody();
      users.forEach(u -> {
        u.setBackup(backup);
        u.getTodos().forEach(todo -> todo.setUser(u));
      });
      backup.setUsers(users);
      backup.setStatus(BackupStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      backup.setStatus(BackupStatus.FAILED);
    } finally {
      backupRepository.save(backup);

    }
  }


}
