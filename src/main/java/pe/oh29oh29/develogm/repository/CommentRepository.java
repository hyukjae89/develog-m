package pe.oh29oh29.develogm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.oh29oh29.develogm.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment> {

    @Modifying
    @Query("DELETE FROM Comment c WHERE c.post = :postId")
    void deleteCommentsByPost(@Param("postId") String postId);

}
