package pe.oh29oh29.develogm.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import pe.oh29oh29.develogm.model.Comment;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.request.PostReq;

import javax.persistence.criteria.Path;

public class CommentSpec {

    public static Specification<Comment> equalPost (final PostReq postReq) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<Post> post = root.get("post");
            return criteriaBuilder.equal(post.get("id"), postReq.getId());
        };
    }
}
