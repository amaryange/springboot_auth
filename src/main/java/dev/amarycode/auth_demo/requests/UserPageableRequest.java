package dev.amarycode.auth_demo.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserPageableRequest<T> {

    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalItems;

}
