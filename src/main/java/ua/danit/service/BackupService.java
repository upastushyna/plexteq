package ua.danit.service;

import ua.danit.entity.Backup;

import java.io.IOException;
import java.util.List;

public interface BackupService {

  List<String> exportBackup(Long backupId ) throws IOException;

  List<Backup> findAllBackups();

}
