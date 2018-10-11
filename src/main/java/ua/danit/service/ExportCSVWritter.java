package ua.danit.service;

import ua.danit.entity.Backup;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ExportCSVWritter {

  List<String> mapToCSV(Backup backup) throws IOException;
  List<String> readCSVfile(File file);
}
