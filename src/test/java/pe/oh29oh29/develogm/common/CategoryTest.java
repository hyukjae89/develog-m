package pe.oh29oh29.develogm.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.repository.CategoryRepository;
import pe.oh29oh29.develogm.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    protected Category mockCategory;

    protected static List<Category> mockCategoryList;

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    @BeforeClass
    public static void beforeClass() {
        mockCategoryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category mockCategory = new Category();
            mockCategory.setName("TestName" + i);
            mockCategory.setDepth(0);
            mockCategory.setOrdering(i);
            mockCategory.setVisible(true);
            mockCategoryList.add(mockCategory);
        }
    }

    @Before
    public void setUp() {
        postRepository.deleteAll();
        categoryRepository.deleteAll();
        mockCategory = mockCategoryList.get(0);
    }

}
