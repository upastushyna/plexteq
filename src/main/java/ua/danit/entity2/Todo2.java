package ua.danit.entity2;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Todo2 {

  @Id
  public String id;

  public String subject;

  public String dueDate;

  private boolean status;
}
