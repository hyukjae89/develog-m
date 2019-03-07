package pe.oh29oh29.develogm.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Post;
import pe.oh29oh29.develogm.repository.CommentRepository;
import pe.oh29oh29.develogm.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    protected Post mockPost;

    protected static List<Post> mockPostList;

    @Autowired
    protected PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @BeforeClass
    public static void beforeClass() {
        mockPostList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post mockPost = new Post();
            mockPost.setTitle("TestTitle" + i);
            mockPost.setContents("TestContents" + i);
            mockPost.setDescription("TestDescription" + i);
            mockPost.setRegDate("1");
            mockPost.setLastUpdateDate("1");
            mockPost.setUrlPathName("TestUrlPathName" + i);
            mockPostList.add(mockPost);
        }
    }

    @Before
    public void setUp() {
        commentRepository.deleteAll();
        postRepository.deleteAll();
        mockPost = mockPostList.get(0);
    }

}
