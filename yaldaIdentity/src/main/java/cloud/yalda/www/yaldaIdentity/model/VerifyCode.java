package cloud.yalda.www.yaldaIdentity.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VerifyCode implements Serializable {
    @Id
    @Column(length = 50,columnDefinition = "varchar(50)",nullable = false)
    private String email;
    @Column(length = 50,columnDefinition = "varchar(50)",nullable = false)
    private String vrfCode;
    @Column(nullable = false)
    private LocalDateTime registerAt;
    @Column(nullable = false)
    private LocalDateTime expireAt;
}
