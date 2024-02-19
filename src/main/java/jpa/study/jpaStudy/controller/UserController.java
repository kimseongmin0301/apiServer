package jpa.study.jpaStudy.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary="가입", description = "회원가입을 합니다. \n RequestBody : name, phone - String Type Not Null")
    public ResponseEntity<?> join(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping("/findAll")
    @Operation(summary="검색", description = "회원 전체를 검색합니다.")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find/{id}")
    @Operation(summary="검색", description = "특정 회원을 검색합니다.")
    public ResponseEntity<?> findById(@PathVariable(value="id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/update/{id}")
    @Operation(summary="수정", description = "특정 회원의 이름을 수정합니다. \n RequestBody : name")
    public ResponseEntity<?> updateId(@PathVariable(value="id") Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.updateById(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="삭제", description = "특정 회원을 삭제합니다.")
    public ResponseEntity deleteId(@PathVariable(value="id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("delete");
    }
}
