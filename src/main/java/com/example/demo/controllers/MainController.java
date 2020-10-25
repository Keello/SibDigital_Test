package com.example.demo.controllers;

import com.example.demo.domain.ArraysTable;
import com.example.demo.services.ArraysTableRepo;
import com.example.demo.services.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    private ArraysTableRepo arraysTableRepo;

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/sort")
    public String add(@RequestParam String text, Model model){
        model.addAttribute("array", text);

        String input = text;
        MyHandler handler = new MyHandler();
        int[] sortedArray = handler.bubbleSort(handler.textPrepare(text));
        model.addAttribute("sortedArray", Arrays.toString(sortedArray));
        ArraysTable array = new ArraysTable(Arrays.toString(sortedArray));

        arraysTableRepo.save(array);

        return "sort";
    }

}
