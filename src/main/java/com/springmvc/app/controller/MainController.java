package com.springmvc.app.controller;

import com.springmvc.app.domain.Orders;
import com.springmvc.app.services.ItemServce;
import com.springmvc.app.services.OrdersService;
import com.springmvc.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemServce itemServce;
    @Autowired
    private OrdersService ordersService;
    public MainController(UserService userService,ItemServce itemServce, OrdersService ordersService){
        this.userService=userService;
        this.itemServce=itemServce;
        this.ordersService=ordersService;
    }

    @RequestMapping("/")
    public  String viewRecords(Model model){
        model.addAttribute("viewUsers",userService.getAllUsersRecords());
        model.addAttribute("viewItems",itemServce.getAllItemsRecords());
        model.addAttribute("viewOrders",ordersService.getAllOrdersRecords());
        return "index";
    }
    @GetMapping("/showNewOrderForm")
    public String showNewOrderForm(Model model) {
        Orders order = new Orders();
        model.addAttribute("order", order);
        return "neworder";

    }
    @PostMapping("/saveOrder")
    public String saveNewOrderRecords(@ModelAttribute("order")Orders order){
        ordersService.saveOrderIntoDB(order);
        return "redirect:/";
    }

}
