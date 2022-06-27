package kz.dar.academy.backend.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

  private String postId;
  private String clientId;
  private String postRecipientId;
  private String postItem;
  private String status;
}
