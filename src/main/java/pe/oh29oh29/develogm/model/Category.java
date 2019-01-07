package pe.oh29oh29.develogm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private int depth;

    @Column
    private int ordering;

    @Column
    private boolean isVisible;
}
