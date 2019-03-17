package pe.oh29oh29.develogm.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "parentCommentId")
    private Comment parentComment;

    @Column
    private String contents;

    @Column
    private String regDate;

    @Column
    private String lastUpdateDate;

    @Column
    private boolean isDeleted;

    @Column
    private int ordering;

    @Column
    private int subOrdering;
}
