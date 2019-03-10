package pe.oh29oh29.develogm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.service.PostService;

@RestController
public class MPostController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public ResponseEntity<PostRes> getPosts (String categoryId, String categoryName, String page) {
        System.out.println(categoryId);
        System.out.println(categoryName);
        System.out.println(page);
        return ResponseEntity.ok(postService.getPosts());
    }
}
