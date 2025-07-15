package ie.stuartgrimes.floweven.controller;

import ie.stuartgrimes.floweven.FlowEvenApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = FlowEvenApplication.class)
public class flowEvenControllerTest {

  @Autowired
  MockMvc mockMvc;

  MockHttpServletRequest mockHttpServletRequest;

  @BeforeEach
  public void setup() {
    mockHttpServletRequest = new MockHttpServletRequest();
  }

  @Test
  void evenFlowControllerModelTest() throws Exception {
    //test for when home page is requested we get back correct model "index"
    MvcResult result = mockMvc.perform(get("/"))
            .andExpect(status().isOk()).andReturn();

    //get the model and confirm it is index
    ModelAndView modelAndView = result.getModelAndView();
    assertEquals("index", modelAndView.getViewName());

    //check model return is not empty
    assertNotNull(modelAndView.getModel().get("dropDown"));
  }


}
