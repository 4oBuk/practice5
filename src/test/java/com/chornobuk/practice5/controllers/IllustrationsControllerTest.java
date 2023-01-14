package com.chornobuk.practice5.controllers;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.entities.Illustration;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        Illustration illustration = new Illustration(1L, null, "illustration1.2", "url",
                LocalDateTime.of(2023, 1, 1, 11, 1), false);
        String expected = objectMapper.writeValueAsString(illustration);
        String responseBody = mockMvc.perform(get("/illustrations/1"))
                .andExpectAll(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(expected, responseBody);
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
        Artist artist = new Artist();
        artist.setId(1L);
        Illustration expected = new Illustration();
        expected.setAiGenerated(true);
        expected.setName("testAiIllustration");
        expected.setId(438L);
        expected.setImageUrl("url");
        expected.setCreatedAt(LocalDateTime.of(2023, 1, 1, 11, 1));
        expected.setArtist(artist);
        String requestBody = """
                {
                    "name" : "testAiIllustration",
                    "artist" : {
                        "id" : 1
                    },
                    "aiGenerated" : true
                }
                """;

        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        result.setArtist(artist);
        assertEquals(expected, result);
    }

    @Test
    public void createIllustrationEmptyName() throws Exception {
        String requestBody = """
                {
                    "name" : "",
                    "artist" : {
                        "id" : 1
                    },
                    "aiGenerated" : true
                }
                """;
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationNullArtist() throws Exception {
        String requestBody = """
                {
                    "name" : "",
                    "artist" : {
                    },
                    "aiGenerated" : true
                }
                """;
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationMissedAiGenerated() throws Exception {
        String requestBody = """
                {
                    "name" : "",
                    "artist" : {
                        "id" : 1
                    },
                }
                """;
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationAttemptToRewriteEntity() throws Exception {
        Artist artist = new Artist();
        artist.setId(1L);
        Illustration expected = new Illustration();
        expected.setAiGenerated(true);
        expected.setName("testAiIllustration");
        expected.setId(438L);
        expected.setImageUrl("url");
        expected.setCreatedAt(LocalDateTime.of(2023, 1, 1, 11, 1));
        expected.setArtist(artist);
        String requestBody = """
                {
                    "id" : 443,
                    "name" : "testAiIllustration",
                    "artist" : {
                        "id" : 1
                    },
                    "aiGenerated" : true
                }
                """;

        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        result.setArtist(artist);
        assertNotEquals(expected.getId(), result.getId());
    }

    @Test
    public void updateIllustrationSuccessful() throws Exception {

    }

    @Test
    public void updateIllustrationAttemptToChangeOwner() throws Exception {

    }

    @Test
    public void updateIllustrationAttemptToUpdateCreationTime() throws Exception {

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
