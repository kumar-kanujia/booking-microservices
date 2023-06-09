package org.jfs.driveinmovie.driveinmovieapp.controller;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.model.Ticket;
import org.jfs.driveinmovie.driveinmovieapp.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.FeignException;

@Controller
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("viewTicket")
    public String showViewTicketPage(){
        return "searchTicket";
    }

    @PostMapping("viewTicket")
    public String viewTicket(@RequestParam String id, ModelMap modelMap){
        modelMap.put("ticket", bookingService.getTicket(id));
        return "ticket";
    }

    @GetMapping("cancelTicket")
    public String deleteTicket(@RequestParam String id, ModelMap modelMap){
        try {
        	bookingService.cancelTicket(id);
        	modelMap.put("msg", "Ticket id " + id + " is canceled");
        }
        catch(FeignException e) {
        	modelMap.put("msg", "Your ticket is already cancelled");
        }
        return "ticket";
    }

    @GetMapping("bookTicket")
    public String getBookingPage(@RequestParam String slotId, ModelMap modelMap){
        modelMap.put("slot", bookingService.getSlot(slotId));
        return "bookTicket";
    }

    @PostMapping("bookTicket")
    public String bookTicket(@ModelAttribute Ticket ticket,@RequestParam String slotId, ModelMap modelMap){
        modelMap.put("ticket", bookingService.bookTicket(slotId ,ticket));
        return "ticket";
    }

    @GetMapping("searchSlot")
    public String searchParkingSlotByTitle(@RequestParam String title, ModelMap modelMap){
        modelMap.put("title", title);
        return "titleSearch";
    }

    @PostMapping("searchSlot")
    public String parkingSlotPageByTitle(@RequestParam String title, ModelMap modelMap){
    	try {
    		modelMap.put("listOfSlots", bookingService.getParkingSlotByTitle(title));
            modelMap.put("title", title);
    	}
    	catch(FeignException e) {
    		modelMap.put("error" , "Slot not found for the movie");
    		return "titleSearch";
    	}
        
        return "slotPage";
    }

    @PostMapping("searchSlotByDate")
    public String searchParkingSlotByTitleAndDate(@RequestParam String title, @RequestParam String date, ModelMap modelMap){
        modelMap.put("listOfSlots", bookingService.getParkingSlotByTitleAndDate(title, date));
        return "slotPage";
    }

}
