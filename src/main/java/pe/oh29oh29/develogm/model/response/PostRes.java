package pe.oh29oh29.develogm.model.response;

import lombok.Data;
import pe.oh29oh29.develogm.model.Page;

import java.util.List;

@Data
public class PostRes {

    private List<PostDetail> posts;
    private Page page;

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
