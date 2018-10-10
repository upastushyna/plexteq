package ua.danit.service;

import ua.danit.entity.Backup;

import java.io.File;
import java.io.IOException;

public interface ExportCSVWritter {

  File mapToCSV(Backup backup) throws IOException;
}
