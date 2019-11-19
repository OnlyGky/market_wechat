package com.in.market.util;


import com.in.market.pojo.user.User;

public class UserThreadLocal {

     private static final ThreadLocal<User> LOCAL = new ThreadLocal<User>();

     private UserThreadLocal(){

     }

     public static void setUser(User user){
          LOCAL.set(user);
     }

     public static User getUser(){
          return LOCAL.get();
     }

}
