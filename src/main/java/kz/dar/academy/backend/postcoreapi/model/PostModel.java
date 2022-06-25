package kz.dar.academy.backend.postcoreapi.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModel {

  private String postId;
  @NotNull(message = "clientId must not be null")
  private String clientId;
  @NotNull(message = "postRecipientId must not be null")
  private String postRecipientId;
  private String postItem;
  private String status;
}
