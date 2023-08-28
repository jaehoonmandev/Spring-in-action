package com.skateboard.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor//인자있는 생성자 주입을 위한 lombok Annotation
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity // JPA의 Entity로 선언하기 위한 Annotation
public class Parts {

    //변수 선언부.
    @Id // 고유 Entity 식별을 위한.
    private final String id; //id 추가

    private final String name;
    private final Type type;

    //열거체 선언.
    public static enum Type {
        GRIP_TAPE, DECK, TRUCK, WHEEL, BEARING,HARDWARE
    }

}
