package ua.danit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
public class Todo {
  @Id
  @Column(name = "internal_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long internalId;

  @Column(name = "todo_external_id", nullable = false)
  private Long id;

  @Column(name = "subject")
  private String subject;

  @Column(name = "dueDate")
  private String dueDate;

  @Column(name = "todo_status")
  private boolean status;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "user_id")
  private User user;

  public String getStatus() {
    return String.valueOf(status);
  }
}
