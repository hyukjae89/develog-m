package pe.oh29oh29.develogm.model.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommentRes {

    private String id;
    private String postId;
    private String memberId;
    private String parentCommentId;
    private String contents;
    private String regDate;
    private String lastUpdateDate;
    private boolean isDeleted;

}
