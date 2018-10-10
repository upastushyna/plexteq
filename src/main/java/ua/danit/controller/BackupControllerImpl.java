package ua.danit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.danit.entity.Backup;
import ua.danit.service.BackupServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class BackupControllerImpl {
  private BackupServiceImpl backupService;

  @Autowired
  public BackupControllerImpl(BackupServiceImpl backupService) {
    this.backupService = backupService;
  }

  @PostMapping("/backups")
  public ResponseEntity<Long> startBackup() {
    return ResponseEntity.ok(backupService.startBackup());
  }

  @GetMapping("/backups")
  public List<Backup> listBackups() {
    return backupService.findAllBackups();
  }

  @GetMapping("/export/{backupId}")
  public ResponseEntity<File> exportBackup (@PathVariable("backupId") Long backupId) throws IOException {
  return ResponseEntity.ok(backupService.exportBackup(backupId));
}

}
