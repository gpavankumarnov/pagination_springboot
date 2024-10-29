package com.example.pagination.controller;
import com.example.pagination.dto.CreatePostDto;
import com.example.pagination.dto.PaginatedDto;
import com.example.pagination.dto.PostDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface PostApi {


  @GetMapping
  PaginatedDto<PostDto> getAllPostsData(@RequestParam(required = false, defaultValue = "50") @Max(50) int pageSize,
                                        @RequestParam(required = false, defaultValue = "1") @Min(1) int page);

@PostMapping
  Long createPostData(@RequestBody @Valid CreatePostDto createPostDto) throws Exception;


}
