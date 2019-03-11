package pe.oh29oh29.develogm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.oh29oh29.develogm.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findAll(Specification<Post> spec);

//    @Modifying
//    @Query("DELETE FROM Post p WHERE p.categoryId = :categoryId")
//    void deletePostsByCategoryId(@Param("categoryId") String categoryId);
}
