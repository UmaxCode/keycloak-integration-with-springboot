package com.umaxcode.Keycloak.Integration.With.Spring.Boot.service.impl;

import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.request.PostRequestDTO;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.response.PostResponseDTO;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.entity.Post;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.repository.PostRepository;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponseDTO addPost(PostRequestDTO post) {

        Post postInstance = Post.builder()
                .title(post.title())
                .content(post.content())
                .build();

        Post savedPost = postRepository.save(postInstance);

        return PostResponseDTO.builder()
                .id(savedPost.getId())
                .title(post.title())
                .content(post.content())
                .build();
    }

    @Override
    public PostResponseDTO updatePost(String id, PostRequestDTO post) {

        Post savedPost = getPostById(id);

        savedPost.setTitle(post.title() != null ? post.title() : savedPost.getTitle());
        savedPost.setContent(post.content() != null ? post.content() : savedPost.getContent());

        Post updatedPost = postRepository.save(savedPost);

        return PostResponseDTO.builder()
                .id(updatedPost.getId())
                .title(updatedPost.getTitle())
                .content(updatedPost.getContent())
                .build();
    }

    @Override
    public void deletePost(String id) {
        Post savedPost = getPostById(id);
        postRepository.delete(savedPost);
    }

    @Override
    public List<PostResponseDTO> getPosts() {

        return postRepository.findAll().stream()
                .map(post -> PostResponseDTO.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build()).toList();
    }

    @Override
    public PostResponseDTO getPost(String id) {

        Post savedPost = getPostById(id);

        return PostResponseDTO.builder()
                .id(savedPost.getId())
                .title(savedPost.getTitle())
                .content(savedPost.getContent())
                .build();
    }

    private Post getPostById(String id) {

        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            return optionalPost.get();
        }

        throw new IllegalArgumentException("Post with id {" + id + "} not found");
    }
}
