package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.request.CommentReq;
import pe.oh29oh29.develogm.model.request.PostReq;
import pe.oh29oh29.develogm.model.response.CommentRes;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.repository.PostRepository;
import pe.oh29oh29.develogm.repository.specification.PostSpec;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    public PostRes getPosts(PostReq postReq) {

        Pageable pageable = PageRequest.of(postReq.getPage() - 1, 5);
        Specification<Post> spec = PostSpec.equalCategory(postReq);

        Page<Post> posts = postRepository.findAll(spec, pageable);

        List<PostRes.PostDetail> postDetailList = new ArrayList<>();
        posts.forEach(post -> {
            PostRes.PostDetail postDetail = new PostRes.PostDetail();
            postDetail.setId(post.getId());
            postDetail.setCategoryId(post.getCategory().getId());
            postDetail.setCategoryName(post.getCategory().getName());
            postDetail.setMemberId(post.getMember().getId());
            postDetail.setTitle(post.getTitle());
            postDetail.setContents(post.getContents());
            postDetail.setDescription(post.getDescription());
            postDetail.setRegDate(post.getRegDate());
            postDetail.setLastUpdateDate(post.getLastUpdateDate());
            postDetail.setPrivate(post.isPrivate());
            postDetail.setUrlPathName(post.getUrlPathName());
            postDetailList.add(postDetail);
        });

        PostRes postRes = new PostRes();
        postRes.setPosts(postDetailList);
        postRes.setPage(new pe.oh29oh29.develogm.model.response.Page(postReq.getPage(), posts.getTotalPages()));

        return postRes;
    }

    public PostRes getPost(PostReq postReq) {

        Post post = postRepository.findOne(PostSpec.equalUrlPathName(postReq)).get();

        PostRes postRes = new PostRes();
        PostRes.PostDetail postDetail = new PostRes.PostDetail();
        postDetail.setId(post.getId());
        postDetail.setCategoryId(post.getCategory().getId());
        postDetail.setCategoryName(post.getCategory().getName());
        postDetail.setMemberId(post.getMember().getId());
        postDetail.setTitle(post.getTitle());
        postDetail.setContents(post.getContents());
        postDetail.setDescription(post.getDescription());
        postDetail.setRegDate(post.getRegDate());
        postDetail.setLastUpdateDate(post.getLastUpdateDate());
        postDetail.setPrivate(post.isPrivate());
        postDetail.setUrlPathName(post.getUrlPathName());

        List<CommentRes> commentResList = commentService.getComments(new CommentReq(post.getId()));

        postRes.setPost(postDetail);
        postRes.setComments(commentResList);

        return postRes;
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void deletePost(PostReq postReq) {
        postRepository.deleteById(postReq.getId());
    }

    public void deletePostsByCategory(String categoryId) {
//        postRepository.deletePostsByCategoryId(categoryId);
    }

}
