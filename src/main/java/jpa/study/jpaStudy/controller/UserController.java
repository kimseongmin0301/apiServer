package jpa.study.jpaStudy.controller;

import jpa.study.jpaStudy.dto.UserDto;
import jpa.study.jpaStudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("join")
    public ResponseEntity<?> join(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateId(@PathVariable(value="id") Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.updateById(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteId(@PathVariable(value="id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("delete");
    }
}
