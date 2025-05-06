package com.example.kiosk.controller;

import com.example.kiosk.dto.UserRegisterDto;
import com.example.kiosk.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MainController {
    // home, register, login
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterDto dto, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(dto);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인 해주세요.");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }

    @GetMapping("/register/signId/{id}")
    public String registerSignId() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // sale
    @GetMapping("/sale/type")
    public String saleType() {
        return "saleType";
    }

    @PostMapping("/sale/type")
    public String saleType(@RequestParam("saleType") int saleType, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("saleType", saleType);
        return "menuForm";
    }

    @PostMapping("/menu")
    public String menu(@RequestParam("saleType") int saleType, Model model) {
        model.addAttribute("saleType", saleType);
        return "menuForm";
    }

}
