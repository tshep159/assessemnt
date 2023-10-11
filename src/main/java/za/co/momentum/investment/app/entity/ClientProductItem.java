package za.co.momentum.investment.app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ClientProductItem")
@Getter
@Setter
@ToString
@Audited
@RequiredArgsConstructor
public class ClientProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Client client;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;

}
