package pe.oh29oh29.develogm.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class PostRes {

    // 리스트
    private List<PostDetail> posts;
    private Page page;

    // 상세보기
    private PostDetail post;
    private List<CommentRes> comments;

    @Data
    public static class PostDetail {
        private String id;
        private String categoryId;
        private String categoryName;
        private String memberId;
        private String title;
        private String description;
        private String contents;
        private String regDate;
        private String lastUpdateDate;
        private int views;
        private boolean isPrivate;
        private String urlPathName;
    }

}
