package ua.danit.service;

import org.springframework.stereotype.Service;
import ua.danit.entity.Backup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExportCSVWritterImpl implements ExportCSVWritter {

  private static final String DEFAULT_PATH = "src/main/resources/PerfectCSVFile.csv" ;

  public File mapToCSV(Backup backup) throws IOException {

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

    return csvFile;
  }

}
