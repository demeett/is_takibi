package com.example.istakip.service;

import com.example.istakip.domain.isDO;
import javassist.NotFoundException;

import java.util.List;

public interface isService {
    public isDO createIs(Long id,isDO is) throws NotFoundException;
    public isDO updateIs(Long id, isDO is);
    public void deleteIs(Long isId);
    public isDO getis(Long isId);
    public List<isDO> getAllIs();
}
