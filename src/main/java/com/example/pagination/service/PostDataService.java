package com.example.pagination.service;
import com.example.pagination.dto.CreatePostDto;
import com.example.pagination.dto.PaginatedDto;
import com.example.pagination.dto.PostDto;
import com.example.pagination.mapper.PostMapper;
import com.example.pagination.model.Posts;
import com.example.pagination.repository.PostRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class PostDataService {
  private PostRepository postRepository;
  private PostMapper postMapper;

  public PostDataService(PostRepository postRepository,
                         PostMapper postMapper) {
    this.postRepository = postRepository;
    this.postMapper = postMapper;
  }

  public PaginatedDto<PostDto> getAllPosts(@Min(1) int page, @Max(50) int pageSize) {
    PageRequest paginationRequest = PageRequest.of(page - 1, pageSize);
           Page<Posts> result =  postRepository.findAll(paginationRequest);
    List<PostDto> postDtos = result.getContent().stream()
        .map(postMapper::convertEntityToDto)
        .toList();
           return new PaginatedDto<>(result.getTotalElements(),postDtos);
  }

  public Long createPost(CreatePostDto createPostDto) {
    Posts post = postMapper.convertCreatePostDtoToEntity(createPostDto);
    postRepository.saveAndFlush(post);

    return post.getId();
  }
}