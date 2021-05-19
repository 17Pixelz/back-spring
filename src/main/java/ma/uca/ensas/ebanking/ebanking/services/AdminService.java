package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.models.Admin;
import ma.uca.ensas.ebanking.ebanking.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAllAdmins(){return adminRepo.findAll();}
}
