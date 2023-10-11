package za.co.momentum.investment.app.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;


import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "Client")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Audited
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String mobileNumber;
    private String emailAddress;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;


}
