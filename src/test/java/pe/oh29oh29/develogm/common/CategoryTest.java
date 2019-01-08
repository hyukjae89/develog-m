package pe.oh29oh29.develogm.common;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.oh29oh29.develogm.model.Category;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    protected static List<Category> mockCategoryList;

    @BeforeClass
    public static void beforeClass() {
        mockCategoryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category mockCategory = new Category();
            mockCategory.setName("Category name" + i);
            mockCategory.setDepth(0);
            mockCategory.setOrdering(i);
            mockCategory.setVisible(true);
            mockCategoryList.add(mockCategory);
        }
    }

}
