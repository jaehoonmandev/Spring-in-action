package com.skateboard.web;

import com.skateboard.DTO.Order;
import com.skateboard.DTO.Parts;
import com.skateboard.DTO.Parts.Type;
import com.skateboard.DTO.Setup;
import com.skateboard.data.PartsRepository;
import com.skateboard.data.SetupRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // Logger 생성(lombok)
@Controller // Spring Context MVC에서 Controller Bean으로 인식
@RequestMapping("/design") // http://[localhost]/design mapping
@SessionAttributes("order") // 주문 기능은 다수의 HTTP 요청에 걸쳐 존재하기에 다수의 요청을 계속해서 받을 수 있게 세션을 보존하는 것.
public class DesignSkateBoardController {

    //Repository Injection
    private final PartsRepository partsRepo;
    private SetupRepository setupRepo;

    @Autowired
    public DesignSkateBoardController(PartsRepository partsRepo, SetupRepository setupRepo){
        this.partsRepo = partsRepo;
        this.setupRepo = setupRepo;
    }

    //GET으로 들어온 요청에 대한 처리
    @GetMapping
    //설정한 데이터를 form형태로 View로 보여준다.
    public String showDesignForm(Model model) {

        List<Parts> parts = new ArrayList<>();
        partsRepo.findAll().forEach(parts::add);

        Type[] types = Parts.Type.values(); // 3번째 인자로 준 구분 열거체의 값을 초기화.
        for (Type type : types) {
            //View로 넘겨줄 Model attribute 설정.
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(parts, type));
        }
        //setup 이라는 attribute 로 Part Domain을 넘겨준다. 이걸로 위에서 넣어준 Attribute 데이터를 핸들링한다.
        model.addAttribute("setup", new Setup());

        //design.html 호출
        return "design";
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

    //@ModelAttribute는 @SessionAttribute로 지정한 세션 값으로 모델이 생성되도록해준다.
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "setup")
    public Setup setup(){
        return new Setup();
    }

    /* [POST 요청 Mapping]
       - 유효성 검사를 위한 @Validated / Errors 추가
       - @ModelAttribute 를 매개변수로 지정함으로써, 매개변수의 값이 모델로부터 전달되어야한다는 것과,
       스프링 MVC가 이 매개변수에 요청 매개변수를 바인딩 하지 않아야한다는 것을 나타냄.
    */
    @PostMapping
    public String processDesign(@Valid Setup setup, Errors errors, @ModelAttribute Order order){
        /*사용자가 선택한 식자재 핸들링하는 부분이다.
        실제로 데이터를 저장하기 위한 메서드*/

        //에러가 포함되어 온다면, 디자인 페이지로
        if(errors.hasErrors()){
            return "design";
        }
        //setupRepo를 통해 보존된 세션을 orderRepo로 넘겨 저장한다.
        Setup saved = setupRepo.save(setup);
        order.addSetup(saved);

        return "redirect:/orders/current";
    }



}