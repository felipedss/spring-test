package br.com.projuris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my-find-char")
public class MyFindCharController {

    @Autowired
    private MyFindChar myFindChar;

    @GetMapping
    public ResponseEntity myFindChar(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(myFindChar.findChar(word));
    }

}
