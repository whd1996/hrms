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
        json.set("prompt", "漂亮小姐姐");
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

