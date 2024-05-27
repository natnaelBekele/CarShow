package com.binary.service;

import com.binary.Entity.Owner;

import java.util.List;

public interface OwnerService {

    public List<Owner> getAllOwners();
    public Owner createOwner(Owner owner);
    public Owner updateOwner(long id, Owner owner);
    public long deleteOwner(long id);
    public Owner getOwnerById(long id);
}

