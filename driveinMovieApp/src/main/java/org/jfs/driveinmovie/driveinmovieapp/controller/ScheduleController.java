package org.jfs.driveinmovie.driveinmovieapp.controller;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.exception.InvalidScheduleDateException;
import org.jfs.driveinmovie.driveinmovieapp.exception.ServiceDownException;
import org.jfs.driveinmovie.driveinmovieapp.model.Schedule;
import org.jfs.driveinmovie.driveinmovieapp.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    @GetMapping("addSchedule")
    public String showAddSchedulePage(ModelMap modelMap){
        modelMap.put("schedule", new Schedule());
        return "addSchedule";
    }

    @PostMapping(value = "addSchedule")
    public String addSchedule(@ModelAttribute Schedule schedule) throws ServiceDownException {
        scheduleService.addSchedule(schedule);
        return "redirect:/addSchedule";
    }

    @GetMapping("viewSchedule")
    public String showViewSchedulePage(){
        return "scheduleSearchPage";
    }

    @PostMapping("viewSchedule")
    public String viewSchedulePage(@RequestParam String date, ModelMap modelMap) throws InvalidScheduleDateException {
        modelMap.put("schedule", scheduleService.viewSchedule(date));
        return "scheduleViewPage";
    }

    @GetMapping("updateSchedule")
    public String showScheduleUpdatePage(@RequestParam String date, ModelMap modelMap) throws InvalidScheduleDateException {
        modelMap.put("schedule", scheduleService.viewSchedule(date));
        return "scheduleUpdatePage";
    }

    @PostMapping("updateSchedule")
    public String updateSchedule(@ModelAttribute Schedule schedule) throws ServiceDownException {
        scheduleService.updateSchedule(schedule);
        return "redirect:/viewSchedule";
    }

    @GetMapping("deleteSchedule")
    public String deleteSchedule(@RequestParam String date) throws ServiceDownException {
        scheduleService.deleteSchedule(date);
        return "redirect:/viewSchedule";
    }


}
