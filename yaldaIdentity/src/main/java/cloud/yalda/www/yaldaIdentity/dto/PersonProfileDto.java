package cloud.yalda.www.yaldaIdentity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonProfileDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -67541720562083848L;
    private long personId;
    private String userId;
    private String fullName;
    private String email;
    private LocalDateTime registerAt;
    private LocalDateTime lastLoginAt;
    private int roleId;
    private boolean isPremium;
    private String photoUri;
    private String fcm;
    private String token;
    private String refreshToken;
}
