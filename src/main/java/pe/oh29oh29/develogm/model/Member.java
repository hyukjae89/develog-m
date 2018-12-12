package pe.oh29oh29.develogm.model;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "members")
@Data
public class Member implements Serializable {

    @Id
    private String id;

    @Column
    private String passwd;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private boolean isAdmin;

    @Column
    private String signUpDate;

    @Column
    private String signInDate;

    @Column
    private boolean isExit;

    @Column
    private String exitDate;

}
