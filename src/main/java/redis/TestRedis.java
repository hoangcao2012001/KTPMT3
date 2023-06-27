package redis;
import java.util.Scanner;
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
public class TestRedis {
 

	public static void main(String[] args) {
		
	
        Jedis jedis = new Jedis("redis://default:C98yuZu6LgZa0yR67fN9b2c8IEZAUVhE@redis-16530.c16.us-east-1-3.ec2.cloud.redislabs.com:16530");
        Connection connection = jedis.getConnection();
 
  
        String UserName1 = jedis.get("User");
//        System.out.println("UserName: " + UserName1);
     // Thực hiện GET Pass "123456a" a

        
//        jedis.set("User","CAOTIENHOANV");
//        String UserName3 = jedis.get("User");
//        System.out.println("UserName: " + UserName3);
     // Tạo một đối tượng JSON
        
        
		
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", UserName1);
        jsonObject.put("Messager", "googd");
        jsonObject.put("age", 25);

        // Lưu trữ đối tượng JSON trong Redis
        jedis.set("send1", jsonObject.toString());
        
        
        
        
        
      
        
     // Lấy giá trị từ khóa "USER"
        String jsonString = jedis.get("send1");

        // Sử dụng Gson để chuyển đổi JSON thành đối tượng Java
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);

        // Truy cập dữ liệu JSON
        if (user != null) {
        	System.out.println("Gửi tin nhắn");
            String UserName = user.getUserName();
            String Messager = user.getMessager();
            int age = user.getAge();

            System.out.println("UserName: " + UserName);
           
            System.out.println("Message: " + Messager);
            System.out.println("Age: " + age);
            System.out.println("----------------");
        }
        
        
        
        
        
        
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("UserName", "Account2");
        jsonObject2.put("Messager", "bye");
        jsonObject2.put("age", 21);

        // Lưu trữ đối tượng JSON trong Redis
        jedis.set("send2", jsonObject2.toString());
        
        
        
        
     // Lấy giá trị từ khóa "USER"
        String jsonString2 = jedis.get("send2");

        // Sử dụng Gson để chuyển đổi JSON thành đối tượng Java
        Gson gson2 = new Gson();
        User user2 = gson.fromJson(jsonString2, User.class);
        String Messager = user.getMessager();
        String UserName = user.getUserName();
     // Truy cập dữ liệu JSON
        if (user2 != null) {
        	System.out.println("Nhận Tin Nhắn nhắn");
        	
        	System.out.println("nguoi gui: "+UserName+" -Message: " + Messager);
        	System.out.println("----------------");
        	System.out.println("Gửi Tin Nhắn nhắn");
            String UserName2 = user2.getUserName();
            String Messager2 = user2.getMessager();
            int age2 = user2.getAge();

            System.out.println("UserName: " + UserName2);
           
            System.out.println("Message: " + Messager2);
            System.out.println("Age: " + age2);
        }
        
        
        // Đóng kết nối Redis
        jedis.close();
    }
		
	 
	}
    
