package org.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {
    private static final List<String> LINES = List.of(
            "The spades are swords of a soldier",
            "The clubs are weapons of war",
            "Diamonds mean money for this art"
    );
    private List<String> lines;

    public TextService() {
        lines = new ArrayList<>(LINES);
    }

    public String getLine(int number) {
        if (number < 0 || number > lines.size()) {
            throw new IllegalArgumentException("input incorrect order");
        }
        return lines.get( number);
    }

    public void addNewLine(String line){
        if(line == null || line.isBlank()){
            throw new IllegalArgumentException("not correct input line");
        }
        if(lines.stream().anyMatch(l -> l.equals(line))){
            throw new IllegalArgumentException("input line is duplicate");
        }
        lines.add(line);
    }
    public List<String> getText(){
        return lines;
    }


}
