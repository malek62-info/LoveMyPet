package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.ItemToDonate; // Modification du nom de l'entité

import java.util.List;

public interface ItemToDonateService { 
    //enregister 
    void saveItemToDonate(ItemToDonate itemToDonate);
    //objets a donné
    public List<ItemToDonate> getAllItems();

    //details produit
    public ItemToDonate getItemById(Integer id);

    //les objets de Id
    public List<ItemToDonate> getItemsByPersonId(Integer personId);



}
