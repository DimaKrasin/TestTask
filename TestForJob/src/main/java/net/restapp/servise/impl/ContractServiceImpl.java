package net.restapp.servise.impl;

import net.restapp.model.Contract;
import net.restapp.model.Document;
import net.restapp.repository.RepositoryContract;
import net.restapp.servise.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    RepositoryContract contractRepo;

    @Override
    public void save(Contract entity) {
        if (entity != null) {
            contractRepo.save((Contract) entity);
        } else {
            System.out.println("Object to save is null!");
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (id != null) {
            contractRepo.delete(id);
        } else {
            System.out.println("Id to delete is null!");
        }
    }

    @Transactional
    @Override
    public Contract getById(Long id) {
        if (id != null) {
            return contractRepo.getOne(id);
        } else {
            System.out.println("Id to get is null!");
            return null;
        }
    }

    @Transactional
    @Override
    public List getAll() {
        return contractRepo.findAll();
    }
}

