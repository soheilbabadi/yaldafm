package cloud.yalda.www.yaldaIdentity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonPhoto implements Serializable {
    @Serial
    private static final long serialVersionUID = -2773185253847666484L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fileId;
    @Lob
    private byte[] fileContent;
    private long fileLen;
    @Column(length = 50,columnDefinition = "varchar(50)")
    private String contentType;
    @Column(length = 50,columnDefinition = "varchar(50)")
    private String fileName;
    private LocalDateTime registerAt;

    @ManyToOne(targetEntity = Person.class,cascade = CascadeType.PERSIST)
    private Person personId;


}
