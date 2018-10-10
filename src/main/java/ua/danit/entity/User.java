package ua.danit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

  @Id
  @Column(name = "internal_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long internalId;

  @Column(name = "user_external_id", nullable = false)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "user_email")
  private String email;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "backupId")
  private Backup backup;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Todo> todos;
}
