package org.jfs.driveinmovie.driveinmovieapp.controller;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class BookingController {

    @GetMapping("viewTicket")
    public String showViewTicketPage(){
        return "searchTicket";
    }

    @PostMapping("viewTicket")
    public String viewTicket(@RequestParam String id, ModelMap modelMap){
        modelMap.put("ticket", new Ticket("12", "gdywu", "wefnw", "hbwefbuke", "jbj", "cjwni", 278,1123.34));
        return "ticket";
    }

    @GetMapping("cancelTicket")
    public String deleteTicket(@RequestParam String id){
        return "ticket";
    }

    @GetMapping("bookTicket")
    public String getBookingPage(){
        return "bookTicket";
    }


}
