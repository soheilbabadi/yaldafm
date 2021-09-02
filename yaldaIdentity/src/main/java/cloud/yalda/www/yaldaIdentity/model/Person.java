package cloud.yalda.www.yaldaIdentity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    @Column(length = 30,columnDefinition = "varchar(30)",nullable = false)
    private String userId;
    @Column(length = 50,columnDefinition = "varchar(50)")
    private String fullName;
    @Column(length = 50,columnDefinition = "varchar(50)")
    private String email;
    @Column(length = 500,columnDefinition = "varchar(500)",nullable = false)
    private String password;
    private LocalDateTime registerAt;
    private LocalDateTime lastLoginAt;
    @Column(nullable = false)
    private int roleId;
    private boolean isPremium;
    @Column(length = 150,columnDefinition = "varchar(150)",nullable = false)
    private String photoUri;
    @Column(length = 500,columnDefinition = "varchar(500)")
    private String fcm;
    @Column(length = 500,columnDefinition = "varchar(500)")
    private String token;
    @Column(length = 500,columnDefinition = "varchar(500)")
    private String refreshToken;

@OneToMany(cascade = CascadeType.PERSIST,targetEntity = PersonPhoto.class,mappedBy = "personId")
    private Set<PersonPhoto> personPhotoSet;


}
