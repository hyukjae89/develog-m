package pe.oh29oh29.develogm.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PostRes {

    private List<PostDetail> posts;
    private Page page;

    private PostDetail post;
    private List<CommentDetail> comments;

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

    @Data
    public static class CommentDetail {
        private String id;
        private String postId;
        private String memberId;
        private List<CommentDetail> children;
        private String contents;
        private String regDate;
        private String lastUpdateDate;
        private boolean isDeleted;
    }

}
