package com.skateboard.web;

import com.skateboard.DTO.Order;
import com.skateboard.data.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    /*Design Controller에서 POST로 Mapping되어 redirect를 호출하는 부분
    * 현재는 GET 요청을 받아 단순히 orderForm.html을 요청하는 기능만 수행한다.*/
    @GetMapping("/current")
    public String orderForm(Model model){
        /*Model 객체를 지정하고 넘겨주면 View딴에서 핸들링이 가능하다
        * 주문 정보를 담는 Order 객체 인스턴스를 넘겨준다.*/
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /*주문 정보 submit처리 POST 메서드*/
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
