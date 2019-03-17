package pe.oh29oh29.develogm.repository;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pe.oh29oh29.develogm.common.CommentTest;
import pe.oh29oh29.develogm.model.Comment;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommentRepositoryTest extends CommentTest {

    @Test
    public void t1_insert() {
        // init
        for (Comment mockComment : mockCommentList) {
            mockComment.setMember(memberRepository.findAll().get(0));
            mockComment.setPost(postRepository.findAll().get(0));

            // test code
            Comment insertedComment = commentRepository.save(mockComment);

            // verification
            assertEquals(mockComment.getContents(), insertedComment.getContents());
            assertEquals(mockComment.getMember().getId(), insertedComment.getMember().getId());
            assertEquals(mockComment.getPost().getId(), insertedComment.getPost().getId());
            assertEquals(mockComment.getRegDate(), insertedComment.getRegDate());
        }

        Comment parentComment = commentRepository.findAll().get(0);
        for (Comment mockChildComment : mockChildCommentList) {
            mockChildComment.setMember(memberRepository.findAll().get(0));
            mockChildComment.setPost(postRepository.findAll().get(0));
            mockChildComment.setParentComment(parentComment);
            mockChildComment.setOrdering(parentComment.getOrdering());

            // test code
            Comment insertedComment = commentRepository.save(mockChildComment);

            // verification
            assertEquals(mockChildComment.getContents(), insertedComment.getContents());
            assertEquals(mockChildComment.getMember().getId(), insertedComment.getMember().getId());
            assertEquals(mockChildComment.getPost().getId(), insertedComment.getPost().getId());
            assertEquals(mockChildComment.getRegDate(), insertedComment.getRegDate());
        }

//        mockPost = insertedPost;
    }


    @Test
    public void t2_findAll() {
        // init
        t1_insert();

        // test code
        List<Comment> commentList = commentRepository.findAll();

        // verification
        assertEquals(5, commentList.size());
    }

//    @Test
//    public void t3_update() {
//        //init
//        t1_insert();
//        Post mockCategory2 = new Post();
//        mockCategory2.setId(mockPost.getId());
//        mockCategory2.setMember(memberRepository.findAll().get(0));
//        mockCategory2.setCategory(categoryRepository.findAll().get(0));
//        mockCategory2.setTitle("UPDATE_TITLE");
//        mockCategory2.setDescription("UPDATE_DESCRIPTION");
//        mockCategory2.setContents("UPDATE_CONTENTS");
//        mockCategory2.setRegDate("2");
//        mockCategory2.setLastUpdateDate("2");
//        mockCategory2.setUrlPathName("UPDATE_URL");
//
//        // test code
//        Post updatedCategory = postRepository.save(mockCategory2);
//
//        // verification
//        assertEquals(mockCategory2.getTitle(), updatedCategory.getTitle());
//        assertEquals(mockCategory2.getMember().getId(), updatedCategory.getMember().getId());
//        assertEquals(mockCategory2.getCategory().getId(), updatedCategory.getCategory().getId());
//        assertEquals(mockCategory2.getContents(), updatedCategory.getContents());
//        assertEquals(mockCategory2.getUrlPathName(), updatedCategory.getUrlPathName());
//    }

//    @Test
//    public void t4_delete() {
//        // init
//        t1_insert();
//        String id = mockPost.getId();
//
//        // test code
//        postRepository.deleteById(id);
//
//        // verification
//        assertEquals(0, postRepository.count());
//    }
}
