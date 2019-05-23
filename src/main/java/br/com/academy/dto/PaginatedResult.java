package br.com.academy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginatedResult<T> {
    private Integer count;
    private List<T> results;
    private String next;
    private String previous;
}
