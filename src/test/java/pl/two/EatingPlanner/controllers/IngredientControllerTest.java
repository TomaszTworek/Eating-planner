package pl.two.EatingPlanner.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.two.EatingPlanner.model.Dish;
import pl.two.EatingPlanner.model.Ingredient;
import pl.two.EatingPlanner.services.IngredientService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
public class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService ingredientService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldReturnStatus200WhenGetAllIngredients() throws Exception {
        mockMvc.perform(get("/ingredients/all").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnStatus200WhenWeAddIngredient() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test");
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(ingredient);


        mockMvc.perform(post("/ingredients/add").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
                .andExpect(status().isOk());
    }

}
