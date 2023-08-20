package com.xpu.hrms.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CaptchaController {
    @GetMapping("/captcha")
    public ResponseEntity<Void> captcha(HttpServletResponse response, HttpSession session) throws IOException {
        // 设置验证码图片的宽度和高度
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(60, 30, 4, 3);
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
      /*  long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);*/
        // 将生成的验证码图片写入到HTTP响应中
        lineCaptcha.write(response.getOutputStream());
        // 保存验证码的值
        session.setAttribute("captcha", lineCaptcha.getCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(String code, HttpSession session) {
        // 从Session中读取保存的验证码的值
        String captcha = (String) session.getAttribute("captcha");
        // 比较用户输入的验证码与保存的验证码的值是否相等
        if (code.equalsIgnoreCase(captcha)) {
            return ResponseEntity.ok("验证码正确");
        } else {
            return ResponseEntity.ok("验证码错误");
        }
    }
}