package service;

import model.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LabServiceRepository;

import java.util.List;

@Service
public class LabServiceService {

    @Autowired
    private LabServiceRepository addressRepository;

    public List<LabService> getAllLabServicees() {
        return (List<LabService>) addressRepository.findAll();
    }

    public LabService getLabService(int id) {
        return addressRepository.findOne(id);
    }

    public int saveLabService(LabService labService) {
        return addressRepository.save(labService).getId();
    }

    public void updateLabService(LabService labService) {
        addressRepository.save(labService);
    }

    public void deleteLabService(int id) {
        addressRepository.delete(id);
    }
}
