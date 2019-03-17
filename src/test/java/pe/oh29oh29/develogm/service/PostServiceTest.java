package pe.oh29oh29.develogm.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.PostTest;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.model.request.PostReq;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.repository.specification.PostSpec;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostServiceTest extends PostTest {

    @Test
    public void t1_addPost() {

    }

    @Test
    public void t2_getPosts() {
        // init
        String categoryId = categoryRepository.findAll().get(0).getId();
        PostReq postReq = new PostReq();
        postReq.setCategoryId(categoryId);

        List<Post> posts = postRepository.findAll(PostSpec.equalCategory(postReq));
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
    }
}
