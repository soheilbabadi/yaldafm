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
public class ProfileUpdateDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -781073938443890533L;
    private long personId;
    private String userId;
    private String fullName;
    private String email;



}
