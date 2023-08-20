import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChatGptDemo001 {
    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //搜索关键字
/*
        "model": "image-alpha-001",
*/
        json.set("model", "image-alpha-001");
        json.set("prompt", "AI机器人 机械 赛博朋克 复古风");
        //生成图片数
        json.set("n", 2);
        //生成图片大小
        json.set("size", "1024x1024");
        //返回格式
        json.set("response_format", "url");

        //发送请求
        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/images/generations")
                .headerMap(headers, false)
                .bearerAuth("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")
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();

        System.out.println(response.body());
    }
}

