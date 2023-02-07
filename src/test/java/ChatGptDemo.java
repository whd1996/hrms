import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ChatGptDemo {
    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.set("model", "text-davinci-003");
        //添加我们需要输入的内容
        json.set("prompt", "java Map中的嵌套Map我怎么拿到？");
        json.set("temperature", 0.9);
        json.set("max_tokens", 2048);
        json.set("top_p", 1);
        json.set("frequency_penalty", 0.0);
        json.set("presence_penalty", 0.6);

        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth("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")
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();

        JSONObject info = new JSONObject(response.body());
        Map<String, Object> map = new HashMap<>();
        //循环转换
        for (Map.Entry<String, Object> entry : info.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        Map<String, Object> mymap = new HashMap<String, Object>();


      /*  Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            mymap.put(fieldName, value);
        }*/
        String choices = JSON.toJSONString(map.get("choices"));
        choices = choices.replace("[", "");
        choices = choices.replace("]", "");
        JSONObject json1 = new JSONObject(choices);
        for (Map.Entry<String, Object> entry : json1.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        System.out.println(map.get("text"));
    }

}

