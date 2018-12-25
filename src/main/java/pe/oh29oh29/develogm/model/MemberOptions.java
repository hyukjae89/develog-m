package pe.oh29oh29.develogm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "member_options")
@Data
public class MemberOptions implements Serializable {

    @Id
    private String memberId;

    @Column
    private String passwdQuestion;

    @Column
    private String passwdAnswer;

}
