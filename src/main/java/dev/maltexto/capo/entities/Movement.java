package dev.maltexto.capo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import dev.maltexto.capo.entities.enums.MovementType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Column(name = "movement_type")
    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    @Column(nullable = false)
    private Integer quantity;

    @CreationTimestamp
    private Date date;

    private String reason;

    private String document;
}
