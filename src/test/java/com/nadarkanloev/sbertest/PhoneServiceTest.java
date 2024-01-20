package com.nadarkanloev.sbertest;

import com.nadarkanloev.sbertest.model.PhoneModel;
import com.nadarkanloev.sbertest.repository.PhoneRepository;
import com.nadarkanloev.sbertest.service.PhoneService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceTest {
    @InjectMocks
    private PhoneService phoneService;
    @Mock
    private PhoneRepository phoneRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllPhones(){
        List<PhoneModel> phones = Arrays.asList(new PhoneModel(), new PhoneModel());
        when(phoneRepository.findAll()).thenReturn(phones);
        List<PhoneModel> result = phoneService.getAllPhones();
        assertEquals(phones.size(), result.size());
    }
    @Test
    public void testGetPhoneByIdNotFound(){
        Long phoneId = 1L;
        when(phoneRepository.findPhoneModelById(phoneId)).thenReturn(null);

        assertThrows(EntityNotFoundException.class, () -> phoneService.deletePhone(phoneId));
        verify(phoneRepository, times(1)).findPhoneModelById(phoneId);
        verify(phoneRepository, never()).delete(any());
    }
    @Test
    public void testCreateNewPhone(){
        PhoneModel phone = new PhoneModel();
        when(phoneRepository.save(phone)).thenReturn(phone);

        PhoneModel res = phoneService.createNewPhone(phone);

        assertEquals(phone, res);
        verify(phoneRepository, times(1)).save(phone);
    }
    @Test
    public void testUpdatePhone(){
        Long phoneId = 1L;
        PhoneModel existingPhone = new PhoneModel();
        PhoneModel updatedPhone = new PhoneModel();
        when(phoneRepository.findPhoneModelById(phoneId)).thenReturn(existingPhone);
        when(phoneRepository.save(existingPhone)).thenReturn(existingPhone);

        PhoneModel result = phoneService.updatePhone(phoneId, updatedPhone);

        assertEquals(existingPhone, result);
        assertEquals(updatedPhone.getYearOfRelease(), existingPhone.getYearOfRelease());
        verify(phoneRepository, times(1)).findPhoneModelById(phoneId);
        verify(phoneRepository, times(1)).save(existingPhone);
    }
    @Test
    public void testDeletePhone(){
        Long phoneId = 1L;
        PhoneModel existingPhone = new PhoneModel();
        when(phoneRepository.findPhoneModelById(phoneId)).thenReturn(existingPhone);

        phoneService.deletePhone(phoneId);

        verify(phoneRepository, times(1)).findPhoneModelById(phoneId);
        verify(phoneRepository, times(1)).delete(existingPhone);
    }
}
