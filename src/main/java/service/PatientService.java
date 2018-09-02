package service;

import exception.NullReferenceException;
import model.Address;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public List<Patient> getPatientsById(int id) {
        return patientRepository.findPatientsById(id);
    }

    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findPatientsByName(name);
    }

    public List<Patient> getPatientsByBirthDay(String birthday) {
        return patientRepository.findPatientsByBirthday(birthday);
    }

    public Patient getPatient(int id) {
        return patientRepository.findOne(id);
    }

    public int savePatient(Patient patient) {
        Patient item = saveToExistItem(patient);
        return patientRepository.save(item).getId();
    }

    public void updatePatient(Patient patient) {
        Patient item = saveToExistItem(patient);
        patientRepository.save(item);
    }

    public void deletePatient(int id) {
        patientRepository.delete(id);
    }

    private Patient saveToExistItem(Patient patient) {
        Address address = patient.getAddress();

        int addressId = address.getId();

        if(addressId > 0) {
            address = addressRepository.findOne(addressId);
        }

        if(address == null) {
            throw new NullReferenceException("Address is required or ensure this address ID is exists");
        }

        patient.setAddress(address);

        return patient;
    }
}
