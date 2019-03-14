package pe.oh29oh29.develogm.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.request.PostReq;

import javax.persistence.criteria.Path;

public class PostSpec {

    public static Specification<Post> equalCategory (final PostReq postReq) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<Category> category = root.get("category");

            if (StringUtils.isEmpty(postReq.getCategoryId())) {
                return criteriaBuilder.equal(category.get("name"), postReq.getCategoryName());
            }

            return criteriaBuilder.equal(category.get("id"), postReq.getCategoryId());
        };
    }

    public static Specification<Post> equalUrlPathName (final PostReq postReq) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("urlPathName"), postReq.getUrlPathName());
        };
    }

}

