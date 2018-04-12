package net.restapp.repository;


import net.restapp.model.Contract;
import net.restapp.model.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryContractTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RepositoryContract repositoryContract;

    @Test
    public void findOne() {

        Contract contract = createContrectForTest();

        entityManager.persist(contract);
        entityManager.flush();

        Contract actualContract = repositoryContract.findOne(contract.getId());

        assertEquals(contract, actualContract);
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void sendNullId() {

        Long id = null;
        repositoryContract.findOne(id);

    }

    private Contract createContrectForTest(){
        Document document = new Document();
        document.setId("someDocumentStringId");
        List<Document> list = new ArrayList<>();
        list.add(document);


        Contract contract = new Contract();
        contract.setData(list);

        return contract;
    }

}
