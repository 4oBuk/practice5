package com.chornobuk.practice5.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.chornobuk.practice5.dtos.illustration.IllustrationCreateDTO;
import com.chornobuk.practice5.dtos.illustration.IllustrationUpdateDTO;
import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.repositories.IllustrationsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IllustrationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IllustrationsRepository illustrationsRepository;

    @Value("${illustrations.per.page}")
    int illustrationsPerPage;

    @Test
    public void getIllustrationByIdSuccessful() throws Exception {
        String responseBody = mockMvc.perform(get("/illustrations/1"))
                .andExpectAll(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Illustration expected = illustrationsRepository.findById(1L).get();
        // set password to null because API doesn't return password
        expected.getArtist().setPassword(null);
        Illustration actual = objectMapper.readValue(responseBody, Illustration.class);

        assertEquals(expected, actual);
    };

    @Test
    public void getIllustrationByIdNoEntity() throws Exception {
        mockMvc.perform(get("/illustrations/" + Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getIllustrationByIdStringParameter() throws Exception {
        mockMvc.perform(get("/illustrations/null"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationSuccessful() throws Exception {
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setAiGenerated(false);
        createDto.setName("testAiIllustration");
        createDto.setArtistId(1L);
        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration actual = objectMapper.readValue(responseBody, Illustration.class);
        Illustration expected = illustrationsRepository.findById(actual.getId()).get();
        // set password to null because API doesn't return password
        expected.getArtist().setPassword(null);// TODO: solve problem with time
        actual.setUpdatedAt(expected.getUpdatedAt());
        assertEquals(expected, actual);
    }

    @Test
    public void createIllustrationUnexistedUser() throws Exception {
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setAiGenerated(false);
        createDto.setName("testAiIllustration");
        createDto.setArtistId(Long.MAX_VALUE);
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createIllustrationEmptyName() throws Exception {
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setName("");
        createDto.setArtistId(1L);
        createDto.setAiGenerated(false);
        System.out.println(objectMapper.writeValueAsString(createDto));
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationNullArtist() throws Exception {
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setName("test");
        createDto.setAiGenerated(false);
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationMissedAiGenerated() throws Exception {
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setName("test");
        createDto.setArtistId(1L);
        createDto.setAiGenerated(null);
        mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createIllustrationAttemptToRewriteEntity() throws Exception {
        Illustration expected = illustrationsRepository.findById(1L).get();
        IllustrationCreateDTO createDto = new IllustrationCreateDTO();
        createDto.setAiGenerated(expected.getAiGenerated());
        createDto.setName(expected.getName());
        createDto.setArtistId(expected.getArtist().getId());
        String responseBody = mockMvc.perform(
                post("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpectAll(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        // entities are the same but with different id
        assertNotEquals(expected.getId(), result.getId());
        expected.setId(result.getId());
        expected.getArtist().setPassword(null);
        result.setUpdatedAt(expected.getUpdatedAt());
        assertEquals(expected, result);
    }

    @Test
    public void updateIllustrationSuccessful() throws Exception {
        IllustrationUpdateDTO updateDto = new IllustrationUpdateDTO();
        updateDto.setId(3L);
        updateDto.setName("updated1.4");
        updateDto.setAiGenerated(false);
        String responseBody = mockMvc.perform(
                put("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpectAll(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Illustration result = objectMapper.readValue(responseBody, Illustration.class);
        Illustration expected = illustrationsRepository.findById(result.getId()).get();
        expected.getArtist().setPassword(null);
        result.setUpdatedAt(expected.getUpdatedAt());
        assertEquals(expected, result);
    }

    @Test
    public void updateIllustrationNoEntity() throws Exception {
        IllustrationUpdateDTO updateDto = new IllustrationUpdateDTO();
        updateDto.setId(Long.MAX_VALUE);
        updateDto.setName("new Entity");
        updateDto.setAiGenerated(false);
        mockMvc.perform(
                put("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpectAll(status().isNotFound());
    }

    @Test
    public void updatableIllustrationBlankName() throws Exception {
        IllustrationUpdateDTO expected = new IllustrationUpdateDTO();
        expected.setId(3L);
        expected.setName("");
        expected.setAiGenerated(false);
        mockMvc.perform(
                put("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateIllustrationAiGeneratedNull() throws Exception {
        IllustrationUpdateDTO expected = new IllustrationUpdateDTO();
        expected.setId(3L);
        expected.setName("test");
        expected.setAiGenerated(null);
        mockMvc.perform(
                put("/illustrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteByIdSuccessful() throws Exception {
        Illustration illustration = illustrationsRepository.findById(1L).get();
        illustration.setId(null);
        Illustration saved = illustrationsRepository.save(illustration);
        mockMvc.perform(delete("/illustrations/" + saved.getId()))
                .andExpect(status().isOk());
        assertFalse(illustrationsRepository.existsById(saved.getId()));
    }

    @Test
    public void deleteByIdNoEntityById() throws Exception {
        mockMvc.perform(delete("/illustrations/" + Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getPaginatedIllustrationsSuccessful() throws Exception {
        int page = 1;
        boolean aiGenerated = false;
        String name = "23.";
        String params = String.format("name=%s&aiGenerated=%b&page=%d", name, aiGenerated, page);
        String response = mockMvc.perform(
                get("/illustrations?" + params))
                .andExpectAll(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        Pageable pageable = PageRequest.of(page, illustrationsPerPage);
        Page<Illustration> pageData = illustrationsRepository.findAllByNameContainingAndAiGenerated(name,
                aiGenerated,
                pageable);
        String expected = objectMapper.writeValueAsString(pageData.getContent());
        assertEquals(expected, response);
    }

    @Test
    public void getPaginatedIllustrationsEmptyName() throws Exception {
        int page = 1;
        boolean aiGenerated = true;
        String name = "";
        String params = String.format("name=%s&aiGenerated=%b&page=%d", name, aiGenerated, page);
        String responseBody = mockMvc.perform(
                get("/illustrations?" + params))
                .andExpectAll(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        Pageable pageable = PageRequest.of(page, illustrationsPerPage);
        Page<Illustration> pageData = illustrationsRepository.findAllByNameContainingAndAiGenerated(name,
                aiGenerated,
                pageable);
        String expected = objectMapper.writeValueAsString(pageData.getContent());
        assertEquals(expected, responseBody);
    }

    @Test
    public void getPaginatedIllustrationsEmptyIsAiGenerated() throws Exception {
        mockMvc.perform(
                get("/illustrations?name=illustration&aiGenerated=&page=120"))
                .andExpectAll(status().isBadRequest());
    }

    @Test
    public void getPaginatedIllustrationsNegativePage() throws Exception {
        mockMvc.perform(
                get("/illustrations?name=illustration&aiGenerated=false&page=-10"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getPaginatedIllustrationsUnexistedPage() throws Exception {
        String responseBody = mockMvc.perform(
                get("/illustrations?name=illustration&aiGenerated=false&page=120"))
                .andExpectAll(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        assertEquals("[]", responseBody);
    }
}
