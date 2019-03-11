package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.repository.PostRepository;
import pe.oh29oh29.develogm.repository.specification.PostSpec;

import java.util.ArrayList;
import java.util.List;

import static pe.oh29oh29.develogm.model.metamodel.Post_.category;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostRes getPosts(String categoryId) {
        Post examplePost = new Post();
        Category exampleCategory = new Category();
        exampleCategory.setId(categoryId);
        examplePost.setCategory(exampleCategory);

        List<Post> posts = postRepository.findAll(Example.of(examplePost));
        PostRes postRes = new PostRes();
        List<PostRes.PostDetail> postDetailList = new ArrayList();
        posts.forEach(post -> {
            PostRes.PostDetail postDetail = new PostRes.PostDetail();
            postDetail.setId(post.getId());
            postDetail.setCategoryId(post.getCategory().getId());
            postDetail.setCategoryName(post.getCategory().getName());
            postDetail.setMemberId(post.getMember().getId());
            postDetail.setContents(post.getContents());
            postDetail.setDescription(post.getDescription());
            postDetail.setRegDate(post.getRegDate());
            postDetail.setLastUpdateDate(post.getLastUpdateDate());
            postDetail.setPrivate(post.isPrivate());
            postDetail.setUrlPathName(post.getUrlPathName());
            postDetailList.add(postDetail);
        });

        postRes.setPosts(postDetailList);

        return postRes;
    }

    public Post getPost(String id) {
        return postRepository.findById(id).get();
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    public void deletePostsByCategory(String categoryId) {
//        postRepository.deletePostsByCategoryId(categoryId);
    }

}
