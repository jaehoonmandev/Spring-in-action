package com.skateboard.web;

import com.skateboard.DTO.Parts;
import com.skateboard.DTO.Parts.Type;
import com.skateboard.DTO.Setup;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // Logger 생성(lombok)
@Controller // Spring Context MVC에서 Controller Bean으로 인식
@RequestMapping("/design") // http://[localhost]/design mapping
public class DesignSkateBoardController {

    //GET으로 들어온 요청에 대한 처리
    @GetMapping
    //설정한 데이터를 form형태로 View로 보여준다.
    public String showDesignForm(Model model) {
        /*여러개의 BoardParts 객체를 초기화하여 ArrayList 형태로 여러개 set
        (ID,값, BoardParts의 Type 열거체 지정)*/
        List<Parts> parts = Arrays.asList(
                //GRIP_TAPE
                new Parts("MOB_GRIP","MOB Grip tape", Type.GRIP_TAPE),
                new Parts("GRZ_GRIP","Grizzly Grip tape", Type.GRIP_TAPE),
                new Parts("JSU_GRIP","Jessup Grip tape", Type.GRIP_TAPE),
                //DECK
                new Parts("SUP_DECK","Supreme Deck", Type.DECK),
                new Parts("BAK_DECK","Baker Deck", Type.DECK),
                new Parts("STC_DECK","Santacruz Deck", Type.DECK),
                //TRUCK
                new Parts("ACE_TRUCK_STA_44","Ace Truck, Standard 44Size", Type.TRUCK),
                new Parts("IND_TRUCK_HOL_139","Independent Truck, Hollow  139Size", Type.TRUCK),
                //WHEEL
                new Parts("BNS_WHEEL_99A","Bones Wheel, 54mm 99A",Type.WHEEL),
                new Parts("SPF_WHEEL_101A","Spitfire Wheel, 56mm 101A",Type.WHEEL),
                //BEARING
                new Parts("BNS_BEARING_REDS","Bones Reds",Type.BEARING),
                new Parts("BRS_BEARING_G3","Bronson G3",Type.BEARING),
                //HARDWARE
                new Parts("BRO_HARDWARE_7_8","Bronze 56k 7/8\"",Type.HARDWARE),
                new Parts("IND_HARDWARE_1","Independent 1\"",Type.HARDWARE)
        );

        Type[] types = Parts.Type.values(); // 3번째 인자로 준 구분 열거체의 값을 초기화.
        for (Type type : types) {
            //View로 넘겨줄 Model attribute 설정.
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(parts, type));
        }
        //setup 이라는 attribute 로 Parts Domain을 넘겨준다. 이걸로 위에서 넣어준 Attribute 데이터를 핸들링한다.
        model.addAttribute("setup", new Setup());

        //design.html 호출
        return "design";
    }

    /*POST 요청 Mapping*/
    @PostMapping
    //유효성 검사를 위한 @Validated / Errors 추가
    public String processDesign(@Valid Setup setup, Errors errors){
        /*사용자가 선택한 식자재 핸들링하는 부분이다.
        * 추후 DB가 구축되면 데이터를 저장하는 기능을 추가할 것이다.
        * 현재는 POST 요청에 대하여 반응하는지만 확인하도록 해보자.
        * */
        //에러가 포함되어 온다면, 디자인 페이지로
        if(errors.hasErrors()){
            return "design";
        }
        log.info("Processing setup: " + setup);

        return "redirect:/orders/current";
    }

    //Ingredient의 클래스에 선언된 Type의 열거체와 현재 받아온 선언 값과 같은 값을 추출.
    private List<Parts> filterByType(
            List<Parts> parts, Type type) {
        //람다를 사용하기 위한 Stream 인스턴스 활용.
        return parts
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}