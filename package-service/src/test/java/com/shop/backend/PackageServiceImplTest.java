package com.shop.backend;

import com.shop.backend.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class PackageServiceImplTest {

    private final String CHAR_EQUAL = "=";
    private final String CHAR_QUESTION = "?";

    @Autowired
    private MockMvc mockMvc;

    private String getUri(String apiUrl, String currency) {
        StringBuilder url = new StringBuilder();
        url.append(apiUrl).append(CHAR_QUESTION).append(getParamString("base", currency));
        return url.toString();
    }

    private String getParamString(String paramName, String paramValue) {
        return paramName + CHAR_EQUAL + paramValue;
    }

    @DisplayName("Currency testing ..")
    @Test
    public void getCurrencyTest() throws Exception{
        String uri = getUri(Constants.URL_CURRENCY,"USD");
        this.mockMvc.perform(get(uri.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rates").exists())
                .andReturn();
    }
}
