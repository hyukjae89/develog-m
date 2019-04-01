package pe.oh29oh29.develogm.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posts")
@Data
@ToString
public class Post implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String contents;

    @Column(updatable= false)
    private String regDate;

    @Column
    private String lastUpdateDate;

    @Column
    private int views;

    @Column
    private boolean isPrivate;

    @Column
    private String urlPathName;

}
