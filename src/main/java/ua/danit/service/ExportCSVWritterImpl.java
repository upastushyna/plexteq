package ua.danit.service;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import ua.danit.entity.Backup;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExportCSVWritterImpl implements ExportCSVWritter {

  private static final String DEFAULT_PATH = "PerfectCSVFile.csv" ;

  public List<String> mapToCSV(Backup backup) throws IOException {

    File csvFile =  new File(DEFAULT_PATH);
    FileWriter writer = new FileWriter(csvFile);

    CSVUtils.writeLine(writer, Arrays.asList("Username", "TodoItemId", "Subject", "DueDate", "Done"));

    backup.getUsers().forEach(user -> user.getTodos().forEach(todo -> {

      List<String> list = new ArrayList<>();
      list.add(user.getUsername());
      list.add(todo.getId().toString());
      list.add(todo.getSubject());
      list.add(todo.getDueDate());
      list.add(todo.getStatus());

      try {
        CSVUtils.writeLine(writer, list);
      } catch (IOException e) {
        e.printStackTrace();
      }

    }));

    writer.flush();
    writer.close();

   return readCSVfile(csvFile);
  }


  public List<String> readCSVfile(File csvFile) {

    List<String> exportList = new ArrayList<>();
    try {
      FileReader filereader = new FileReader(csvFile);
      CSVReader csvReader = new CSVReader(filereader);
      String[] nextRecord;

      while ((nextRecord = csvReader.readNext()) != null) {
        for (String cell : nextRecord) {
          exportList.add(cell);
        }
        System.out.println();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return exportList;
  }

}
