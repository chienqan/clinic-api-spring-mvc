package service;

import model.LabTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LabTestRepository;

import java.util.List;

@Service
public class LabTestService {

    @Autowired
    private LabTestRepository addressRepository;

    public List<LabTest> getAllLabTestes() {
        return (List<LabTest>) addressRepository.findAll();
    }

    public LabTest getLabTest(int id) {
        return addressRepository.findOne(id);
    }

    public int saveLabTest(LabTest labTest) {
        return addressRepository.save(labTest).getId();
    }

    public void updateLabTest(LabTest labTest) {
        addressRepository.save(labTest);
    }

    public void deleteLabTest(int id) {
        addressRepository.delete(id);
    }
}
