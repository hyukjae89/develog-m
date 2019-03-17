package pe.oh29oh29.develogm.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Comment;
import pe.oh29oh29.develogm.repository.CommentRepository;
import pe.oh29oh29.develogm.repository.MemberRepository;
import pe.oh29oh29.develogm.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    protected Comment mockComment;

    protected static List<Comment> mockCommentList;
    protected static List<Comment> mockChildCommentList;

    @Autowired
    protected CommentRepository commentRepository;

    @Autowired
    protected MemberRepository memberRepository;

    @Autowired
    protected PostRepository postRepository;

    @BeforeClass
    public static void beforeClass() {
        mockCommentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Comment mockComment = new Comment();
            mockComment.setContents("TestCommentContents" + i);
            mockComment.setRegDate("2019031310000" + i);
            mockComment.setLastUpdateDate("1");
            mockComment.setOrdering(i);
            mockCommentList.add(mockComment);
        }

        mockChildCommentList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Comment mockComment = new Comment();
            mockComment.setContents("TestChildCommentContents" + i);
            mockComment.setRegDate("2019031310001" + i);
            mockComment.setLastUpdateDate("1");
            mockComment.setSubOrdering(i);
            mockChildCommentList.add(mockComment);
        }
    }

    @Before
    public void setUp() {
        commentRepository.deleteAll();
        mockComment = mockCommentList.get(0);
    }

}
