package com.example.kiosk.controller;

import com.example.kiosk.dto.UserJoinDto;
import com.example.kiosk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserFormController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(UserJoinDto dto, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(dto);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인 해주세요.");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
