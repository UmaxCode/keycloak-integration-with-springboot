package com.umaxcode.Keycloak.Integration.With.Spring.Boot.service;

import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.request.PostRequestDTO;
import com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {

    PostResponseDTO addPost(PostRequestDTO post);

    PostResponseDTO updatePost(String id, PostRequestDTO post);

    void deletePost(String id);

    List<PostResponseDTO> getPosts();

    PostResponseDTO getPost(String id);
}
