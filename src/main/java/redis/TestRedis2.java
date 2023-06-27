package redis;
import redis.clients.jedis.Jedis;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;

import entity.User;
import redis.clients.jedis.Jedis;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;
import com.google.gson.Gson;


import java.util.Map;
public class TestRedis2 {
    private static Object useranRedis;

	public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:C98yuZu6LgZa0yR67fN9b2c8IEZAUVhE@redis-16530.c16.us-east-1-3.ec2.cloud.redislabs.com:16530");
        Connection connection = jedis.getConnection();
 
		
        String UserName2 = jedis.get("User2");
//        System.out.println("UserName: " + UserName1);
     // Thực hiện GET Pass "123456a" a

        
//        jedis.set("User","CAOTIENHOANV");
//        String UserName3 = jedis.get("User");
//        System.out.println("UserName: " + UserName3);
     // Tạo một đối tượng JSON
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", UserName2);
        jsonObject.put("Messager", "Goodbye");
        jsonObject.put("age", 25);

        // Lưu trữ đối tượng JSON trong Redis
        jedis.set("USER", jsonObject.toString());
        
     // Lấy giá trị từ khóa "USER"
        String jsonString = jedis.get("send2");
        
        //lay gia tri nhận
        String jsonString2 = jedis.get("send1");

        // Sử dụng Gson để chuyển đổi JSON thành đối tượng Java
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);
        User user2 = gson.fromJson(jsonString2, User.class);
		
		if (user2 != null) {
        String UserName21 = user2.getUserName();
        String Messager2 = user2.getMessager();
     
        int age2 = user2.getAge();

        System.out.println("UserName: " + UserName21);
        System.out.println("Message nhận : " + Messager2);
        System.out.println("Age: " + age2);
        System.out.println("-----------------------");

    }
        // Truy cập dữ liệu JSON
        if (user != null) {
            String UserName = user.getUserName();
            String Messager = user.getMessager();
            int age = user.getAge();

            System.out.println("UserName: " + UserName);
            System.out.println("Message gửi đi: " + Messager);
            System.out.println("Age: " + age);
            
            
    
        
        

        // Đóng kết nối Redis
        jedis.close();
    }

	}
	
    }
