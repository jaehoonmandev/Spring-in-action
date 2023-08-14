package com.skateboard.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Setup {

    private Long id;
    //등록된 날짜를 표시하기 위한 속성 추가.
    private Date createdAt;

    @NotBlank
    @Size(min=2, message = "2글자 이상 작성해주세요.")
    private String name;

    @Size(min=1, message="1개이상의 파츠를 고르세요.")
    private List<String> parts; // Controller 에서 복수 리스트를 선언.
}
