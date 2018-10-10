package ua.danit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import ua.danit.entity.Backup;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
public class BackupApplication {
  public static void main(String[] args) {
    SpringApplication.run(BackupApplication.class);
  }
}
