package ua.danit.entity2;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Backup2 {
  @Id
  public String id;

  @CreatedDate
  private Date date;

  public String status;


}
