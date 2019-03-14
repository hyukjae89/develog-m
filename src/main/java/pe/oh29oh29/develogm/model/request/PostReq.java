package pe.oh29oh29.develogm.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PostReq {

    private String id;
    private String categoryId;
    private String categoryName;
    private int page;
    private String urlPathName;

}
