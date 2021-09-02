package cloud.yalda.www.yaldaIdentity.service;

import cloud.yalda.www.yaldaIdentity.repo.PersonRepo;

public class PersonServiceImp {

    private final PersonRepo _personRepo;

    public PersonServiceImp(PersonRepo personRepo) {
        _personRepo = personRepo;
    }
    
}
