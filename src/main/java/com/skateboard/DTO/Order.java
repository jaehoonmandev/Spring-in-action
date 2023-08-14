package com.skateboard.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Date;

/*주문한 정보를 담는 Order Domain 생성.*/
@Data
public class Order {

    private Long id;

    //등록된 날짜를 표시하기 위한 속성 추가.
    private Date createdAt;

    @NotBlank(message="배송지 이름을 입력해주세요.")
    private String deliveryName;

    @NotBlank(message="도시를 적어주세요.")
    private String deliveryCity;

    @NotBlank(message="동을 적어주세요.")
    private String deliveryState ;

    @NotBlank(message="상세 주소를 적어주세요.")
    private String deliveryStreet;

    @NotBlank(message="우편번호를 적어주세요.")
    private String deliveryZip;

    @CreditCardNumber(message = "유효하지 않은 카드 번호입니다.")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$" ,message = "MM/YY의 형식을 맞춰주세요.")
    private String ccExpiration;

    @Digits(integer = 3, fraction=0, message="유효하지 않은 CVV")
    private String ccCVV;
}
