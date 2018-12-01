package pe.oh29oh29.develogm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "members")
@Getter
@Setter
public class Member implements Serializable {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private boolean isAdmin;

    @Column
    private String provider;

    @Column
    private String regDate;

    @Column
    private boolean isExit;

    @Column
    private String exitDate;

}
