package com.fastjson.gson.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fastjson.gson.utils.utils.GsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getElementValueClick(View view) {
        String json = "{\"username\":\"zhangsan\",\"age\":28}";
        String username = GsonUtils.getNoteJsonString(json, "username");

        //注意：在从Json中获取不到字段值时报错（要么没有这个字段，要么字段取错了）
        //String json2 = "{}";
        //String username2 = GsonUtils.getNoteJsonString(json2, "username");

        String jsonObj = "{\"code\":0,\"result\":{\"username\":\"aaa\",\"age\":12}}";
        String code = GsonUtils.getNoteJsonString(jsonObj,"code");
        if ("0".equals(code)){
            User user = GsonUtils.parserJsonToArrayBean(jsonObj, "result",User.class);
            System.out.println("user=" + user.toString());//User{username='aaa', age=12}
        }


        //--------将JSON转换成集合对象-----------start
        String jsonArr = "{\"code\":0,\"result\":[{\"username\":\"aaa\",\"age\":12},{\"username\":\"bbb\",\"age\":13}]}";
        //第一种 - List：
        String codeArr = GsonUtils.getNoteJsonString(jsonArr,"code");
        if ("0".equals(codeArr)){
            List<User> userList = GsonUtils.parserJsonToArrayBeans(GsonUtils.getNoteJsonString(jsonArr, "result"), User.class);
            System.out.println("user1=" + userList.toString());//[User{username='aaa', age=12}, User{username='bbb', age=13}]
        }

        //第二种 - List：
        List<User> userList2 = GsonUtils.parserJsonToArrayBeans(jsonArr, "result", User.class);
        System.out.println("user2=" + userList2.toString());//[User{username='aaa', age=12}, User{username='bbb', age=13}]

        //第二种 - Map：
        String jsonMap = "{\"111\":{\"username\":\"xxx\",\"age\":11},\"222\":{\"username\":\"www\",\"age\":12}}";
        Map<String, User> objectObjectMap = GsonUtils.parseJsonToMap(jsonMap);
        System.out.println("map=" + objectObjectMap);//{111={username=xxx, age=11.0}, 222={username=www, age=12.0}}


        //--------将对象（List，Map，Object）转换成Json-----------start

        //1.转换List<User>
        List<User> toUserList = new ArrayList<>();
        toUserList.add(new User("aaa",11));
        toUserList.add(new User("bbb",12));
        String toListJsonStr = GsonUtils.toJsonString(toUserList);

        //2.转换Map<String,User>
        Map<String,User> map = new HashMap<>();
        map.put("111",new User("xxx",11));
        map.put("222",new User("www",12));

        String toMapJsonStr = GsonUtils.toJsonString(map);

        //3.转换Object
        User toUser = new User("zhouwei",27);
        String toUserJsonStr = GsonUtils.toJsonString(toUser);

        System.out.println("toListJsonStr=" + toListJsonStr);//[{"username":"aaa","age":11},{"username":"bbb","age":12}]
        System.out.println("toMapJsonStr=" + toMapJsonStr);//{"111":{"username":"xxx","age":11},"222":{"username":"www","age":12}}
        System.out.println("toUserJsonStr=" + toUserJsonStr);//{"username":"zhouwei","age":27}

    }
}
