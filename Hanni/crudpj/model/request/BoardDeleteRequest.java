package hello.crudpj.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDeleteRequest {
    private Long boardNo;
}