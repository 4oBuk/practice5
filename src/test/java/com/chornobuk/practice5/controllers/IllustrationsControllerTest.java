package com.chornobuk.practice5.controllers;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.chornobuk.practice5.data.Artists;
import com.chornobuk.practice5.entities.Illustration;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IllustrationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getIllustrationByIdSuccessful() throws Exception {
        Illustration illustration = new Illustration();
        illustration.setId(1L);
        illustration.setArtist( Artists.getById(1L));
        illustration.setImageUrl("url");
        illustration.setName("illustration1.2");
        illustration.setAiGenerated(false);
        String responseBody = mockMvc.perform(get("/illustrations/1"))
                .andExpectAll(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Illustration actual = objectMapper.readValue(responseBody, Illustration.class);
        illustration.setUpdatedAt(actual.getUpdatedAt());
        assertEquals(illustration, actual);
    };

    @Test
    public void getIllustrationByIdNoEntity() throws Exception {
        mockMvc.perform(get("/illustrations/500"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getIllustrationByIdStringParameter() throws Exception {
        mockMvc.perform(get("/illustrations/null"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationSuccessful() throws Exception {
        Illustration expected = new Illustration();
        expected.setAiGenerated(true);
        expected.setName("testAiIllustration");
        expected.setImageUrl("url");
        expected.setArtist(Artists.getById(1L));
        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expected)))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        expected.setId(result.getId());
        expected.setUpdatedAt(result.getUpdatedAt());
        assertEquals(expected, result);
    }

    @Test
    public void createIllustrationEmptyName() throws Exception {
        Illustration newIllustration = new Illustration();
        newIllustration.setName("");
        newIllustration.setArtist(Artists.getById(1L));
        newIllustration.setAiGenerated(true);
        System.out.println(objectMapper.writeValueAsString(newIllustration));
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newIllustration)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationNullArtist() throws Exception {
        Illustration newIllustration = new Illustration();
        newIllustration.setName("test");
        newIllustration.setAiGenerated(true);
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newIllustration)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationMissedAiGenerated() throws Exception {
        Illustration newIllustration = new Illustration();
        newIllustration.setName("");
        newIllustration.setArtist(Artists.getById(1L));
        newIllustration.setAiGenerated(null);
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newIllustration)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationAttemptToRewriteEntity() throws Exception {
        Illustration expected = new Illustration();
        expected.setAiGenerated(true);
        expected.setName("testAiIllustration");
        expected.setId(1L);
        expected.setImageUrl("url");
        expected.setArtist(Artists.getById(1L));
        expected.setUpdatedAt(LocalDateTime.of(2023, 1, 1, 11, 1));

        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expected)))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        assertNotEquals(expected.getId(), result.getId());
    }

    @Test
    public void updateIllustrationSuccessful() throws Exception {
        Illustration expected = new Illustration();
        expected.setId(3L);
        expected.setName("updated1.4");
        expected.setArtist(Artists.getById(1L));
        expected.setAiGenerated(false);
        expected.setImageUrl("url");
        String responseBody = mockMvc.perform(
                put("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expected)))
                .andExpectAll(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        expected.setUpdatedAt(result.getUpdatedAt());
        assertEquals(expected, result);
    }

    @Test
    public void updateIllustrationNoEntity() throws Exception {

    }

    @Test
    public void updatableIllustrationBlankName() throws Exception {

    }

    @Test
    public void updateIllustrationAiGeneratedNull() throws Exception {

    }

    @Test
    public void deleteByIdSuccessful() throws Exception {

    }

    @Test
    public void deleteByIdNoEntityById() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsSuccessful() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsEmptyName() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsEmptyIsAiGenerated() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsNegativePage() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsZeroPage() throws Exception {

    }

    @Test
    public void getPaginatedIllustrationsUnexistedPage() throws Exception {

    }
}
