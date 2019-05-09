
package com.belajar.spring.controller;

import com.belajar.spring.entity.Krs;
import com.belajar.spring.service.DosenService;
import com.belajar.spring.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/krs")
public class KrsController {
    @Autowired
    private KrsService service;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Krs());
        return "/krs/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", service.findById(id));
        return "/krs/update";
    }

    @PostMapping(value = "/create")
    public String save(Krs param) {
        Krs data = service.save(param);
        if (data.getIdKrs() == 0) {
            return "redirect:/krs?failed";
        } else {
            return "redirect:/krs?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Krs param) {
        Krs data = service.update(param);
        if (data.getIdKrs() == 0) {
            return "redirect:/krs?ufailed";
        } else {
            return "redirect:/krs?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Krs param) {
        int data = service.delete(param);
        if (data == 0) {
            return "redirect:/krs?dfailed";
        } else {
            return "redirect:/krs?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", service.find());
        } else {
            Krs krs = new Krs();
            krs.setNameJurusan(param);
            model.addAttribute("dataSets", service.findByName(krs));
        }
        return "/krs/list";
    }

}