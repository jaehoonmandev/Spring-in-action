package com.skateboard.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Parts {

    //변수 선언.
    private final String id;

    //등록된 날 짜를 표시하기 위한 속성 추가.
    private Date placedAt;

    private final String name;
    private final Type type;

    //열거체 선언.
    public static enum Type{
        GRIP_TAPE, DECK, TRUCK, WHEEL, BEARING,HARDWARE
    }

}
