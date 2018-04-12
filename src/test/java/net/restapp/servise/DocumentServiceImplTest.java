package net.restapp.servise;

import net.restapp.model.Document;
import net.restapp.repository.RepositoryDocument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceImplTest {

    @MockBean
    RepositoryDocument documentRepo;

    @Autowired
    DocumentService documentService;


    @Before
    public void setUp() {

        Document document1 = createDocumentForTest();
        Document document2 = createDocumentForTest();

        List<Document> list = Arrays.asList(document1, document2);

        Mockito.when(documentService.getAll())
                .thenReturn(list);

    }

    @Test
    public void getAll() {
        Document document1 = createDocumentForTest();
        Document document2 = createDocumentForTest();

        List<Document> list = Arrays.asList(document1, document2);

        List<Document> found = documentService.getAll();

        Assert.assertEquals(found, list);
    }


    @Test()
    public void saveWithoutExistingDepartment(){
        Document document = createDocumentForTest();

        // Arrange
        when(documentRepo.save(document)).thenReturn(document);
        // Act
        documentService.save(document);
        // Assert
        verify(documentRepo, times(1)).save(document);
    }


    @Test
    public void save() {
        Document document = createDocumentForTest();

        // Arrange
        when(documentRepo.save(document)).thenReturn(document);
        // Act
        documentService.save(document);
        // Assert
        verify(documentRepo, times(1)).save(document);
    }



    private Document createDocumentForTest(){
        Document document = new Document();
        document.setId("tmpStringId");
        document.setUrl("tmpUrl");
        //document.setContract();
        document.setFormat("tmpFormat");
        document.setDateModified("tmpDateModified");
        document.setDatePublished("tmpDatePublished");
        document.setDocumentOf("tmpDocumentOf");
        document.setHash("tmpHash");
        document.setTitle("tmpTitle");

        return document;
    }
}
