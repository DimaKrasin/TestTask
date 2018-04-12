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
    public void delete(Long id) {
        if(id!=null) {
            documentRepo.delete(id);
        }else {
            System.out.println("Id to delete is null!");
        }
    }

    @Override
    public Document getById(Long id) {
        if(id!=null){
            return documentRepo.getOne(id);}
        else {
            System.out.println("Id to get is null!");
            return null;
        }
    }

    @Override
    public List getAll() {
        return documentRepo.findAll();
    }
}

