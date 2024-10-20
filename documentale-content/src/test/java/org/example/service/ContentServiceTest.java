package org.example.service;

import org.example.dao.ContentRepository;
import org.example.dao.model.Content;
import org.example.service.dtos.DocConfigDto;
import org.example.service.impl.ConfigServiceClient;
import org.example.service.impl.ContentServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ContentServiceTest {

    @Mock
    private ConfigService configService;
    @Mock
    private ContentRepository contentRepository;


    @InjectMocks
    private ContentService contentService;

    @Before
    public void setUp() {
        configService = new ConfigServiceClient();
        contentService = new ContentServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveContentByDepartment(){
        DocConfigDto configDto = new DocConfigDto();
        configDto.setId(1L);
        configDto.setSize(1024L);
        configDto.setDepartment("IT");
        configDto.setPath("/path/for/it");
        configDto.setDocType(Arrays.asList("pdf","text"));

        when(configService.getConfigByDepartment("IT")).thenReturn(configDto);

        Content content = new Content();
        content.setId(1L);
        content.setContent("hello world");
        content.setContentType("pdf");
        content.setSize(1024L);
        content.setPath("/path/for/it");
        when(contentRepository.save(content)).thenReturn(content);

        Content contentSaved = contentService.saveContentByDepartment(content,"IT");

        assertNotNull(contentSaved);
        assertEquals("/path/for/it",content.getPath());

        verify(contentRepository).save(content);
    }
}
