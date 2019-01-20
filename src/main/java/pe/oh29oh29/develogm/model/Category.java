package pe.oh29oh29.develogm.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column
    private String name;

    @Column
    private int depth;

    @Column
    private int ordering;

    @Column
    private int isVisible;
}
