package com.gaewoodi.bookstore.dto;

import lombok.Data;

@Data
public class BookImageDto {
    private int imageId;
    private String bookCode;
    private String saveName;
    private String originName;
    private Long size;
}
