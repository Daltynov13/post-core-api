package kz.dar.academy.backend.postcoreapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String postId;
  @NotNull(message = "clientId must not be null")
  private String clientId;
  @NotNull(message = "postRecipientId must not be null")
  private String postRecipientId;
  private String postItem;
  private String status;
}
