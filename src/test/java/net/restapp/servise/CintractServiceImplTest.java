package net.restapp.servise;

import net.restapp.model.Contract;
import net.restapp.model.Document;
import net.restapp.repository.RepositoryContract;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CintractServiceImplTest {

    @MockBean
    RepositoryContract repositoryContract;

    @Autowired
    ContractService contractService;


    @Before
    public void setUp() {

        Contract contract1 = createContractForTest();
        Contract contract2 = createContractForTest();
        List<Contract> list = Arrays.asList(contract1,contract2);

        Mockito.when(contractService.getAll())
                .thenReturn(list);

    }

    @Test
    public void getAll() {
        Contract contract1 = createContractForTest();
        Contract contract2 = createContractForTest();
        List<Contract> list = Arrays.asList(contract1,contract2);

        List<Contract> found = contractService.getAll();

        Assert.assertEquals(found, list);
    }


    @Test()
    public void saveWithoutExistingDepartment(){
        Contract contract = createContractForTest();

        // Arrange
        when(repositoryContract.save(contract)).thenReturn(contract);
        // Act
        contractService.save(contract);
        // Assert
        verify(repositoryContract, times(1)).save(contract);
    }


    @Test
    public void save() {
        Contract contract = createContractForTest();

        // Arrange
        when(repositoryContract.save(contract)).thenReturn(contract);
        // Act
        contractService.save(contract);
        // Assert
        verify(repositoryContract, times(1)).save(contract);
    }



    private Contract createContractForTest(){

        Contract contract = new Contract();

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

        List<Document> list = Arrays.asList(document);
        contract.setData(list);

        return contract;
    }

}
