package com.example.pagination.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedDto<T> {

  @Builder.Default
  long totalCount = 0;

@Builder.Default
List<T> items = new ArrayList<>();



}
