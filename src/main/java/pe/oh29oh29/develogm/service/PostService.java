package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostRes getPosts() {
        List<Post> posts = postRepository.findAll();
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
