package redis;
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
    private static Object useranRedis;

	public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:C98yuZu6LgZa0yR67fN9b2c8IEZAUVhE@redis-16530.c16.us-east-1-3.ec2.cloud.redislabs.com:16530");
        Connection connection = jedis.getConnection();
 
		
        String username2 = jedis.get("User");
        System.out.println("Username: " + username2);
     // Thực hiện GET Pass "123456a" a
        String password = jedis.get("Pass");
        System.out.println("Password: " + password);
        
        jedis.set("User","CAOTIENHOANG");
        String username3 = jedis.get("User");
        System.out.println("Username: " + username3);
    }


	
    }
