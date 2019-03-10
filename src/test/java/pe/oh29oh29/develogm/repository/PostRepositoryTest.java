package pe.oh29oh29.develogm.repository;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.PostTest;
import pe.oh29oh29.develogm.model.Post;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostRepositoryTest extends PostTest {

    @Test
    public void t1_insert() {
        // init
        mockPost.setMember(memberRepository.findAll().get(0));
        mockPost.setCategory(categoryRepository.findAll().get(0));

        // test code
        Post insertedPost = postRepository.save(mockPost);

        // verification
        assertEquals(mockPost.getTitle(), insertedPost.getTitle());
        assertEquals(mockPost.getMember().getId(), insertedPost.getMember().getId());
        assertEquals(mockPost.getCategory().getId(), insertedPost.getCategory().getId());
        assertEquals(mockPost.getContents(), insertedPost.getContents());
        mockPost = insertedPost;
    }

    @Test
    public void t2_findAll() {
        // init
        t1_insert();

        // test code
        List<Post> categoryList = postRepository.findAll();

        // verification
        assertEquals(1, categoryList.size());
    }

    @Test
    public void t3_update() {
        //init
        t1_insert();
        Post mockCategory2 = new Post();
        mockCategory2.setId(mockPost.getId());
        mockCategory2.setMember(memberRepository.findAll().get(0));
        mockCategory2.setCategory(categoryRepository.findAll().get(0));
        mockCategory2.setTitle("UPDATE_TITLE");
        mockCategory2.setDescription("UPDATE_DESCRIPTION");
        mockCategory2.setContents("UPDATE_CONTENTS");
        mockCategory2.setRegDate("2");
        mockCategory2.setLastUpdateDate("2");
        mockCategory2.setUrlPathName("UPDATE_URL");

        // test code
        Post updatedCategory = postRepository.save(mockCategory2);

        // verification
        assertEquals(mockCategory2.getTitle(), updatedCategory.getTitle());
        assertEquals(mockCategory2.getMember().getId(), updatedCategory.getMember().getId());
        assertEquals(mockCategory2.getCategory().getId(), updatedCategory.getCategory().getId());
        assertEquals(mockCategory2.getContents(), updatedCategory.getContents());
        assertEquals(mockCategory2.getUrlPathName(), updatedCategory.getUrlPathName());
    }

    @Test
    public void t4_delete() {
        // init
        t1_insert();
        String id = mockPost.getId();

        // test code
        postRepository.deleteById(id);

        // verification
        assertEquals(0, postRepository.count());
    }
}
