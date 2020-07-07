package pl.two.EatingPlanner.controllers.api;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.two.EatingPlanner.models.modelApi.APIIngredients;
import pl.two.EatingPlanner.models.modelApi.Common;
import pl.two.EatingPlanner.models.modelNutritions.APINutritients;
import pl.two.EatingPlanner.models.modelNutritions.Food;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
@CrossOrigin
public class NutritionAPI {

    @GetMapping("getIngredient/{ingredientName}")
    public List<Common> getCommonsIngredientsFromAPI(@PathVariable String ingredientName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "9afacef3");
        httpHeaders.add("x-app-key", "a82dbf12437787ac179e89666314bf00");
        httpHeaders.add("x-remote-user-id", "0");
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Access-Control-Allow-Origin", "http://localhost:4200/");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<APIIngredients> responseEntity
                = restTemplate.exchange("https://trackapi.nutritionix.com/v2/search/instant?query=" + ingredientName + "&branded=false",
                HttpMethod.GET,
                httpEntity,
                APIIngredients.class
        );

        return responseEntity.getBody().getCommon();
    }

    @PostMapping(value = "/getNutrition", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<Food> getIngredientNutrition(@RequestBody APINutritients apiNutritients) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "9afacef3");
        httpHeaders.add("x-app-key", "a82dbf12437787ac179e89666314bf00");
        httpHeaders.add("x-remote-user-id", "0");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Access-Control-Allow-Origin", "http://localhost:4200/");


        HttpEntity httpEntity = new HttpEntity(apiNutritients, httpHeaders);

        ResponseEntity<APINutritients> exchange = rest.exchange(
                "https://trackapi.nutritionix.com/v2/natural/nutrients",
                HttpMethod.POST,
                httpEntity,
                APINutritients.class
        );
        return exchange.getBody().getFoods();
    }
}
