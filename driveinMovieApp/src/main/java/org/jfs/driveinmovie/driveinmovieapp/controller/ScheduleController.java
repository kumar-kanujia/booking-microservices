package org.jfs.driveinmovie.driveinmovieapp.controller;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.model.Schedule;
import org.jfs.driveinmovie.driveinmovieapp.model.ScheduleMovie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ScheduleController {

    @GetMapping("viewSchedule")
    public String showViewSchedulePage(){
        return "scheduleSearchPage";
    }

    @PostMapping("viewSchedule")
    public String viewSchedulePage(@RequestParam String date, ModelMap modelMap){
        System.out.println(date);
        ScheduleMovie scheduleMovie = new ScheduleMovie("Tarzan", 10.0, 10.0, 10.0);
        modelMap.put("schedule", new Schedule("1", "2020-12-12", scheduleMovie, scheduleMovie, scheduleMovie));
        return "scheduleViewPage";
    }

    @GetMapping("updateSchedule")
    public String showScheduleUpdatePage(@RequestParam String id, ModelMap modelMap){
        System.out.println(id);
        ScheduleMovie scheduleMovie = new ScheduleMovie("Tarzan", 10.0, 10.0, 10.0);
        modelMap.put("schedule", new Schedule("1", "2020-12-12", scheduleMovie, scheduleMovie, scheduleMovie));
        return "scheduleUpdatePage";
    }

    @PostMapping("updateSchedule")
    public String updateSchedule(@ModelAttribute Schedule schedule){
        return "redirect:/viewSchedule";
    }

    @GetMapping("deleteSchedule")
    public String deleteSchedule(@RequestParam String id){
        return "redirect:/viewSchedule";
    }

    @GetMapping("addSchedule")
    public String showAddSchedulePage(ModelMap modelMap){
        modelMap.put("schedule", new Schedule());
        return "addSchedule";
    }

    @PostMapping(value = "addSchedule")
    public String showAddSchedulePage(@ModelAttribute Schedule schedule, ModelMap modelMap){
        return "redirect:/addSchedule";
    }

}
