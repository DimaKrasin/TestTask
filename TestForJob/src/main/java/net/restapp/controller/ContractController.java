package net.restapp.controller;

import net.restapp.model.Contract;
import net.restapp.model.Document;
import net.restapp.retrofit.ContractRetrofitInterface;
import net.restapp.servise.ContractService;
import net.restapp.servise.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    DocumentService documentService;

    @Autowired
    ContractService contractService;

    //add contract and document to BD by link(contractId)
    @RequestMapping(value = "addByRestLink/{contractId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addContractToBD(HttpServletRequest request, @PathVariable("contractId") String contractId) {

        String baseUrl = "https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/";

        if (contractId == null) {
            System.out.println("contractId is empty!");
            return;
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContractRetrofitInterface contractRetrofitInterface = retrofit.create(ContractRetrofitInterface.class);

        Response response = null;

        try {
            response = contractRetrofitInterface.FacingContractGet(contractId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (response == null) {
            System.out.println("Response  is empty!");
            return;
        }


        Contract contract = (Contract) response.body();
        contract.getData();
        contractService.save(contract);

        if (contract.getData() == null) {
            System.out.println("Documents == null");
            ;
            return;
        }

        List<Document> list = contract.getData();
        list.forEach((o) -> o.setContract(contract));
        list.forEach((o) -> documentService.save(o));
    }

}
