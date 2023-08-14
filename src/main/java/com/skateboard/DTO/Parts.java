package com.skateboard.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Parts {

    //변수 선언부.
    private final String id; //id 추가
    private final String name;
    private final Type type;

    //열거체 선언.
    public static enum Type{
        GRIP_TAPE, DECK, TRUCK, WHEEL, BEARING,HARDWARE
    }

}
