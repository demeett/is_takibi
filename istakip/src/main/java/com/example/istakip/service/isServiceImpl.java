package com.example.istakip.service;

import com.example.istakip.domain.PersonelDO;
import com.example.istakip.domain.isDO;
import com.example.istakip.repository.PersonelRepository;
import com.example.istakip.repository.isRepository;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class isServiceImpl implements isService{
    @Autowired
    private PersonelRepository personelRepository;

    @Autowired
    private isRepository isrepository;
    @Override
    public isDO createIs(Long id, isDO is) throws NotFoundException {
        final PersonelDO personelDO=personelRepository.findById(id).orElseThrow(()->new NotFoundException("Kullanıcı bulunamadı."));

        is.setPersonel(personelDO);



        return isrepository.save(is);



    }


    @SneakyThrows
    @Override
    public isDO updateIs(Long id ,isDO is)  {
        final isDO isdo= isrepository.findById(id).orElseThrow(()->new NotFoundException("İş bulunamadı"));
        is.setIsadi(is.getIsadi());



        return isrepository.save(is);
    }

    @Override
    public void deleteIs(Long isId) {
        Optional<isDO> isnesnesi=isrepository.findById(isId);
        if (isnesnesi.isPresent()){
            isrepository.deleteById(isId);
        }



    }

    @Override
    public isDO getis(Long isId) {
        Optional<isDO> getirilenis=isrepository.findById(isId);
        if (getirilenis.isPresent()){
            return getirilenis.get();
        }

        return null;
    }

    @Override
    public List<isDO> getAllIs() {
        return isrepository.findAll();
    }
}
