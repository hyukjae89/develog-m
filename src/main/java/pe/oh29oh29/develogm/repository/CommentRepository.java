package pe.oh29oh29.develogm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.oh29oh29.develogm.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
