package com.umaxcode.Keycloak.Integration.With.Spring.Boot.controller;

import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.request.PostRequestDTO;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.response.SuccessResponse;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PreAuthorize("hasAnyRole('user', 'admin')")
    @PostMapping
    public ResponseEntity<SuccessResponse> addAPost(@RequestBody PostRequestDTO post) {

        var response = postService.addPost(post);

        return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.builder()
                .message("Post created successfully")
                .data(response)
                .build());
    }

    @PreAuthorize("hasAnyRole('user', 'admin')")
    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getAPost(@PathVariable String id) {

        var response = postService.getPost(id);

        return ResponseEntity.ok(SuccessResponse.builder()
                .message("Post found")
                .data(response)
                .build());
    }

    @PreAuthorize("hasAnyRole('user', 'admin')")
    @GetMapping
    public ResponseEntity<SuccessResponse> getAllPosts() {

        var response = postService.getPosts();

        return ResponseEntity.ok(SuccessResponse.builder()
                .message("Posts found")
                .data(response)
                .build());
    }

    @PreAuthorize("hasAnyRole('user', 'admin')")
    @PatchMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateAPost(@PathVariable String id, @RequestBody PostRequestDTO post) {
        var response = postService.updatePost(id, post);

        return ResponseEntity.ok(SuccessResponse.builder()
                .message("Post updated successfully")
                .data(response)
                .build());
    }

    @PreAuthorize("hasAnyRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteAPost(@PathVariable String id) {
        postService.deletePost(id);
        return ResponseEntity.ok(SuccessResponse.builder()
                .message("Post deleted successfully")
                .build());
    }
}
