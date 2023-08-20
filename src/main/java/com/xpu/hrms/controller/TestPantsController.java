package com.xpu.hrms.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description:
 *
 * @author whd
 * @version 1.0.0
 * &#064;date  2023/08/20 13:42:58
 */
@Controller
public class TestPantsController {

    private final static String URL = "https://api.uomg.com/api/rand.img3?sort=胖次猫&format=json";

    @GetMapping("/girl")
    public String showGirls() {
        return "redirect:" + JSONObject.parseObject(HttpUtil.get(URL)).get("imgurl");
    }
}
