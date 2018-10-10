package ua.danit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "backup")
public class Backup {

  @Id
  @Column(name = "backupId")
  @GeneratedValue (strategy = GenerationType.SEQUENCE)
  private Long backupId;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date date;

  @Enumerated(EnumType.STRING)
  private BackupStatus status;

  public Backup() {
    this.status = BackupStatus.IN_PROGRESS;
  }

  @JsonIgnore
  @OneToMany(mappedBy = "backup", cascade = CascadeType.ALL)
  private List<User> users;
}
