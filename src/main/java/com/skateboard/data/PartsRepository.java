package com.skateboard.data;

import com.skateboard.DTO.Parts;

public interface PartsRepository {
    //Iterable 은 오브젝트를 for 문이나 for-loop와 같이 다수의 결과를 호출 할 수 있게하는 타입이다.
    Iterable<Parts> findAll();

    //인자로 id를 함께 넘겨 where 절의 value로 제공하기 위해.
    Parts findById(String id);

    Parts save(Parts parts);
}
