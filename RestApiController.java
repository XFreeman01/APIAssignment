package com.csc340.RestAPI;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Xavier Freeman
 */
@RestController
public class RestApiController {

    @GetMapping("/jokes")
    public Object getJoke() {

        // Random Joke API to display random joke information. 
        String url = "https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonJoke = restTemplate.getForObject(url, Object.class);

        String joke = restTemplate.getForObject(url, String.class);
        JSONObject jo = new JSONObject(joke);
        System.out.println(jo.toString());
        String question = jo.getString("setup");
        String PunchLine = jo.getString("punchline");
        System.out.println(question);
        System.out.println(PunchLine);

        return jSonJoke;
    }
}
