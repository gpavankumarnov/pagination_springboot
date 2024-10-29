package com.example.pagination.mapper;
import com.example.pagination.dto.CreatePostDto;
import com.example.pagination.dto.PostDto;
import com.example.pagination.model.Posts;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PostMapper {
  PostDto convertEntityToDto(Posts Posts);


  Posts convertCreatePostDtoToEntity(CreatePostDto postDto);

}
