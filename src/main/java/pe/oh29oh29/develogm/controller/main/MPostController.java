package pe.oh29oh29.develogm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.develogm.model.request.PostReq;
import pe.oh29oh29.develogm.model.response.PostRes;
import pe.oh29oh29.develogm.service.PostService;

@RestController
@RequestMapping("/post")
public class MPostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public ResponseEntity<PostRes> getPosts(PostReq postReq) {
        return ResponseEntity.ok(postService.getPosts(postReq));
    }

    @GetMapping("/detail")
    public ResponseEntity<PostRes> getPost(PostReq postReq) {
        return ResponseEntity.ok(postService.getPost(postReq));
    }

}
