package pe.oh29oh29.develogm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.develogm.model.response.Response;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public ResponseEntity<Response> homeView() {
        return ResponseEntity.ok(null);
    }


}
