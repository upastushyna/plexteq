package ua.danit.entity2;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User2 {

  @Id
  public String id;

  public String username;
  public String email;

  public User2() {}

  public User2(String id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }

  @Override
  public String toString() {
    return String.format(
        "ua.danit.Customer[id=%s, firstName='%s', lastName='%s']",
        id, username, email);
  }
}
