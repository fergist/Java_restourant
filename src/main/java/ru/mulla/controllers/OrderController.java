package ru.mulla.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mulla.entities.*;
import ru.mulla.security.ReworkedPersonInfo;
import ru.mulla.services.DishService;
import ru.mulla.services.OrderService;
import ru.mulla.services.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class  OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private DishService dishService;
    @Autowired
    private UserService userService;
    private NumberOfEntities numberOfEntities = new NumberOfEntities(1);

    public OrderController(OrderService orderService, DishService dishService) {
        this.orderService = orderService;
        this.dishService = dishService;
    }



    @PostMapping("/shopCartPost")
    public String getNumberOfEntities(@ModelAttribute NumberOfEntities numberOfEntities) {
        this.numberOfEntities = numberOfEntities;
        return "redirect:/shopCart";
    }

    @GetMapping("/shopCart")
    public String getShoppingCart(Model model) {
        Order order = new Order();
        List<OrderEntity> orderEntities = new ArrayList<>();
        order.setOrderEntities(orderEntities);
        for (int i = 0; i < numberOfEntities.getNumber(); i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setDish(new Dish());
            order.addOrderEntity(orderEntity);
        }
        model.addAttribute("numberOfEntities", numberOfEntities);
        model.addAttribute("order", order);
        return "shopCart";
    }

    @PostMapping("/add-order")
    public String addNewOrder(@ModelAttribute Order order, @ModelAttribute OrderEntity orderEntities,
                              @AuthenticationPrincipal ReworkedPersonInfo reworkedPersonInfo) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        order.setOrderDate(currentDate.format(formatter));
        order.setUser(reworkedPersonInfo.getUser());
        for (OrderEntity orderEntity : order.getOrderEntities()) {
            orderService.saveOrderEntity(orderEntity);
        }
        orderService.saveOrder(order);
        return "redirect:acc";
    }

    @GetMapping("/")
    public String getStart() {
        return "redirect:catalog";
    }

    @GetMapping("/catalog")
    public String getCatalog(Model model) {
        model.addAttribute("numberOfEntities", numberOfEntities);
        model.addAttribute("dishList", dishService.findAll());
        return "catalog";
    }

    @GetMapping("/acc")
    public String getAccount(Model model , @AuthenticationPrincipal ReworkedPersonInfo reworkedPersonInfo) {
        Long id = reworkedPersonInfo.getUser().getId();
        model.addAttribute("numberOfEntities", numberOfEntities);
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("orders", orderService.getOrdersByUserId(id));
        return "acc";
    }
}
