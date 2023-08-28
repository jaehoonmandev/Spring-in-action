package com.skateboard.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Setup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// DB에서 자동으로 생성해주는 ID 값 부여.
    private Long id;

    //등록된 날짜를 표시하기 위한 속성 추가.
    private Date createdAt;

    @NotNull
    @Size(min=2, message = "2글자 이상 작성해주세요.")
    private String name;

    @ManyToMany(targetEntity = Parts.class)// N:N의 관계를 설정.
    @Size(min=1, message="1개이상의 파츠를 고르세요.")
    private List<Parts> parts; // Controller 에서 복수 리스트를 선언.

    @PrePersist // Setup 객체가 저장되기 전 자동으로 createAt의 값에 현재 날짜와 시간을 넣어주기 위한.
    void createAt(){
        this.createdAt = new Date();
    }
}
