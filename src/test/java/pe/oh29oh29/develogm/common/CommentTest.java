package pe.oh29oh29.develogm.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Comment;
import pe.oh29oh29.develogm.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    protected Comment mockComment;

    protected static List<Comment> mockCommentList;

    @Autowired
    protected CommentRepository commentRepository;

    @BeforeClass
    public static void beforeClass() {
        mockCommentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Comment mockComment = new Comment();
            mockComment.setContents("TestContents" + i);
            mockComment.setRegDate("1");
            mockComment.setLastUpdateDate("1");
            mockCommentList.add(mockComment);
        }
    }

    @Before
    public void setUp() {
        commentRepository.deleteAll();
        mockComment = mockCommentList.get(0);
    }

}
