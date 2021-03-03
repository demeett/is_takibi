package com.example.istakip.service;

import com.example.istakip.domain.PersonelDO;

public interface PersonelService {

    public PersonelDO createPersonel(PersonelDO personel);
    public PersonelDO updatePersonel(PersonelDO personel);
    public void deletePersonel(Long personelId);
    public PersonelDO getPersonel(Long personelId);



}
