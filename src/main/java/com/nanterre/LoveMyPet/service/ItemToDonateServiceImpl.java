package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.ItemToDonate;
import com.nanterre.LoveMyPet.repository.ItemToDonateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemToDonateServiceImpl implements ItemToDonateService {

    @Autowired
    private ItemToDonateRepository itemToDonateRepository;

    @Override
    public void saveItemToDonate(ItemToDonate itemToDonate) {
        itemToDonateRepository.save(itemToDonate);
    }

    @Override
    public List<ItemToDonate> getAllItems() {
        return itemToDonateRepository.findAll();
    }

    @Override
    public ItemToDonate getItemById(Integer id) {
        return itemToDonateRepository.findById(id).orElse(null);
    }
    //les objets de Id
    @Override
    public List<ItemToDonate> getItemsByPersonId(Integer personId) {
        return itemToDonateRepository.findByDonatingPerson_IdPerson(personId);
    }

}
