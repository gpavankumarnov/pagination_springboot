package com.example.pagination.controller;
import com.example.pagination.dto.CreatePostDto;
import com.example.pagination.dto.PaginatedDto;
import com.example.pagination.dto.PostDto;
import com.example.pagination.service.PostDataService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController implements PostApi{


  public PostDataService postDataService;

  public PostController(PostDataService postDataService){
    this.postDataService = postDataService;
  }

  @Override
  @ApiResponse(responseCode = "200", description = "OK")
  @ApiResponse(responseCode = "400", description = "Not found")
  public PaginatedDto<PostDto> getAllPostsData(
      @RequestParam(required = false, defaultValue = "50") @Max(50) int pageSize,
      @RequestParam(required = false, defaultValue = "1") @Min(1) int page
  ){
return postDataService.getAllPosts(page, pageSize);
  }

  @Override
  @ApiResponse(responseCode = "200", description = "OK")
  @ApiResponse(responseCode = "400", description = "Not found")
  public Long createPostData(CreatePostDto createPostDto)  {
  return  postDataService.createPost(createPostDto);
  }



}
