package com.example.istakip.service;

import com.example.istakip.domain.PersonelDO;

import java.util.List;

public interface PersonelService {

    public PersonelDO createPersonel(PersonelDO personel);
    public PersonelDO updatePersonel(PersonelDO personel);
    public void deletePersonel(Long personelId);
    public PersonelDO getPersonel(Long personelId);
    public List<PersonelDO> getAllPersonel();



}
