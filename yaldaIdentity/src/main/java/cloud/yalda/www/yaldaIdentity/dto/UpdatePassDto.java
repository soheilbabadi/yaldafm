package cloud.yalda.www.yaldaIdentity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePassDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -4894622609111650049L;

    private long personId;
    private String oldPass;
    private String newPass;
}
