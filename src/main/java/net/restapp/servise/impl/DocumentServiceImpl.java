package net.restapp.servise.impl;


import net.restapp.model.Document;
import net.restapp.repository.RepositoryDocument;
import net.restapp.servise.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    RepositoryDocument documentRepo;

    @Override
    public void save(Document entity) {
        if(entity!=null) {
            documentRepo.save(entity);
        }else {
            System.out.println("Object to save is null!");
        }
    }


    @Override
    public List getAll() {
        return documentRepo.findAll();
    }
}

