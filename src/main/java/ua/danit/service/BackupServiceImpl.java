package ua.danit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.danit.entity.Backup;
import ua.danit.repository.BackupRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BackupServiceImpl implements BackupService {
  private BackupRepository backupRepository;
  private BackupProcessingService backupProcessingService;
  private final ExportCSVWritter exportCSVWritter;

  @Autowired
  public BackupServiceImpl(BackupRepository backupRepository,
                           BackupProcessingService backupProcessingService,
                           ExportCSVWritter exportCSVWritter) {
    this.backupRepository = backupRepository;
    this.backupProcessingService = backupProcessingService;
    this.exportCSVWritter = exportCSVWritter;
  }

  public Long startBackup() {
    Backup backup = new Backup();
    backup = backupRepository.save(backup);
    backupProcessingService.startBackup(backup);
    return backup.getBackupId();
  }

  @Override
  public File exportBackup(Long backupId) throws IOException {
    Backup backup = backupRepository.getOne(backupId);
    File file = exportCSVWritter.mapToCSV(backup);
    return file;
  }

  @Override
  public List<Backup> findAllBackups() {
    return backupRepository.findAll();
  }

}
