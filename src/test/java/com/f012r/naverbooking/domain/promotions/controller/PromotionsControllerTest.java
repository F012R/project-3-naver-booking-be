package com.f012r.naverbooking.domain.promotions.controller;

import com.f012r.naverbooking.domain.promotions.service.PromotionsService;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.ImageNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PromotionsController.class)
public class PromotionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PromotionsService promotionsService;

    @Test
    public void testGetPromotions_ImageNotFoundException() throws Exception {
        // given
        Mockito.when(promotionsService.getPromotions()).thenThrow(new ImageNotFoundException(ResponseCode.ImageNotFoundException));

        // when & then
        mockMvc.perform(get("/api/promotions"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Image Not Found"))
                .andDo(print());

    }
}
