package org.example.controller;

import org.example.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="lines")
public class TextInputController {
    private TextService textService;

    public TextInputController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("{number}")
    public String getLine(@PathVariable("number") int number){
       return textService.getLine(number);
    }
    @GetMapping("text")
    public List<String> getText(){
        return textService.getText();
    }
    @PostMapping("add")
    public String addNewLine(@RequestBody String line){
        textService.addNewLine(line);
        return  "Your message are accepted";
    }

}
