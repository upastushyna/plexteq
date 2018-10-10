package ua.danit.service;

import ua.danit.entity.Backup;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface BackupService {

  File exportBackup(Long backupId ) throws IOException;

  List<Backup> findAllBackups();

}
