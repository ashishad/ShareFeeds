package com.learning.sharefeeds;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/*
REST API class
 */
@Controller
public class APIs {

    ArrayList<User> users =new ArrayList<>(); //storing all user
    ArrayList<Feed> feeds=new ArrayList<>(); //storing new feeds

    @GetMapping(path="")
    public String indexPage(){
        return "home_page";
    }

    /* API to get register form
    sending empty user object-form can map the user properties and fill in the values
    */
    @GetMapping("register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register_form";
    }

    /* API to post the user data
       getting the user data from register form and adding it to the "users" list
    */
    @PostMapping(path = "register_user")
    public String registerUser(User newUser){
        for(User user:users) {
            if (user.getEmailId().equals(newUser.getEmailId())) {
                return "user_exists";
            }
        }
        users.add(newUser);
        return "register_success";
    }

    /* API to get login form
    sending empty user object-form can map the user properties and fill in the values
    */
    @GetMapping("login")
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "login_form";
    }

    /* API to login with the particular mailID and password
    if user exists, open the feeds page
    */
    @PostMapping(path = "login_user")
    public String logIn(User user, Model model){
        for (User currUser: users){
            if(currUser.getEmailId().equals(user.getEmailId()) && currUser.getPassword().equals(user.getPassword())){
                model.addAttribute("feeds",feeds);
                return "user_page";
            }
        }
        return "user_not_found";
    }

    /* API to log out
       re-direct to home page
    */
    @GetMapping(path = "logout")
    public String logOut(){
        return "home_page";
    }

    /* API to create post
    sending empty Feed object->form can map the post attribute and fill it.
    */
    @GetMapping(path = "create_post")
    public String create_post(Model model){
        model.addAttribute("feed" , new Feed() );
        return "create_post";
    }

    /* API to post the feed
       adding feed object to "feeds" list
    */
    @PostMapping(path = "post_feed")
    public String postFeed(Feed feed, Model model){
        feeds.add(feed);
        model.addAttribute("feeds",feeds);
        return "user_page";
    }
}