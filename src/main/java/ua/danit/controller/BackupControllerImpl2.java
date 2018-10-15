package ua.danit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.danit.service.BackupServiceImpl2;

@RestController
public class BackupControllerImpl2 {
  private BackupServiceImpl2 backupServiceImpl2;

  @Autowired
  public BackupControllerImpl2(BackupServiceImpl2 backupServiceImpl2) {
    this.backupServiceImpl2 = backupServiceImpl2;
  }

  @PostMapping("/backups")
  public ResponseEntity<?> startBackupMongo() {
    return ResponseEntity.ok(backupServiceImpl2.startBackupMongoDB());
  }
}
