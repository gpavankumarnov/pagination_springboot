package com.example.pagination.dto;
import lombok.*;
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostDto {


  private String title;

  private String body;


}
