package ua.danit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.danit.entity.Backup;
import ua.danit.entity2.Backup2;
import ua.danit.repository.BackupRepository2;

@Service
public class BackupServiceImpl2 {
  private BackupRepository2 backupRepository2;
  private BackupProcessingService2 backupProcessingService2;

  @Autowired
  public BackupServiceImpl2(BackupRepository2 backupRepository2,
                            BackupProcessingService2 backupProcessingService2) {
    this.backupRepository2 = backupRepository2;
    this.backupProcessingService2 = backupProcessingService2;
  }

  public String startBackupMongoDB() {
    Backup2 backup2 = new Backup2();
    backup2 = backupRepository2.save(backup2);
    backupProcessingService2.startBackup(backup2);
    return backup2.getId();
  }
}
