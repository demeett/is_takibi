package com.example.istakip.service;

import com.example.istakip.domain.DepartmanDO;
import com.example.istakip.domain.PersonelDO;
import com.example.istakip.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class PersonelServiceImpl implements PersonelService{

    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public PersonelDO createPersonel(PersonelDO personel) {
        return personelRepository.save(personel);
    }

    @Override
    public PersonelDO updatePersonel(PersonelDO personel) {
        long personelId= personel.getId();
        Optional<PersonelDO> currentPersonel = personelRepository.findById(personelId);
        if (currentPersonel.isPresent()){
            currentPersonel.get().setName(personel.getName());
            currentPersonel.get().setSurname(personel.getSurname());

            DepartmanDO personalDepartman= currentPersonel.get().getDepartman();
            if (personalDepartman==null){
                personalDepartman= new DepartmanDO();


            }
            personalDepartman.setDepartmanadi(personel.getDepartman().getDepartmanadi());
            PersonelDO savedPersonel=personelRepository.save(currentPersonel.get());
            personalDepartman.setId(savedPersonel.getDepartman().getId());
            currentPersonel.get().setDepartman(personalDepartman);



            //PersonelDO savedPersonel=personelRepository.save(currentPersonel.get());
            return savedPersonel;
        }
        return null;
    }

    @Override
    public void deletePersonel(Long personelId) {
        Optional<PersonelDO> currentPersonel=personelRepository.findById(personelId);
        if (currentPersonel.isPresent()){
            personelRepository.deleteById(personelId);
        }

    }

    @Override
    public PersonelDO getPersonel(Long personelId) {
        Optional<PersonelDO> currentPersonel=personelRepository.findById(personelId);
        if (currentPersonel.isPresent()){
            return currentPersonel.get();
        }
        return null;
    }
}
