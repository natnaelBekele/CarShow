package com.binary.service;

import com.binary.Entity.Owner;
import com.binary.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner createOwner(Owner owner) {
        if (owner == null) {
            return null;
        }
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(long id, Owner updatedOwner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            if (updatedOwner.getFirstName() != null) {
                owner.setFirstName(updatedOwner.getFirstName());
            }
            if (updatedOwner.getLastname() != null) {
                owner.setLastname(updatedOwner.getLastname());
            }
            return ownerRepository.save(owner);
        }
        return null;
    }

    @Override
    public long deleteOwner(long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            ownerRepository.deleteById(id);
            return id;
        }
        return -1;
    }

    @Override
    public Owner getOwnerById(long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.orElse(null);
    }
}