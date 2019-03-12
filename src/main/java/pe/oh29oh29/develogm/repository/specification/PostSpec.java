package pe.oh29oh29.develogm.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.Post;

import javax.persistence.criteria.Path;

public class PostSpec {

    public static Specification<Post> category (final String categoryId) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<Category> category = root.get("category");
            return criteriaBuilder.equal(category.get("id"), categoryId);
        };
    }
}
