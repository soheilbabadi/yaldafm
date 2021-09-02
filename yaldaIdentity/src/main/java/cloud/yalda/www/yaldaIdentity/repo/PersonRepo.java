package cloud.yalda.www.yaldaIdentity.repo;


import cloud.yalda.www.yaldaIdentity.CustomeExceptions.UserException;
import cloud.yalda.www.yaldaIdentity.dto.*;
import cloud.yalda.www.yaldaIdentity.helper.Utils;
import cloud.yalda.www.yaldaIdentity.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Repository
public interface PersonRepo extends CrudRepository<Person,Long> {

    Optional<Person> findDistinctByEmail(String email);
    Optional<Person> findDistinctByUserId(String userId);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email,String password);


    interface PersonService {
        PersonProfileDto getProfile(String id) throws UserException;

        boolean authenticate(String email, String password);

        boolean isExists(String email);

        int update(ProfileUpdateDto dto) throws UserException;

        int updatePassword(UpdatePassDto dto) throws UserException;

        String register(String email) throws UserException;
    }

    @Service
    @Slf4j
    class PersonServiceImp implements PersonService {
        @Autowired
        private final PersonRepo _personRepo;

        public PersonServiceImp(PersonRepo personRepo) {
            _personRepo = personRepo;
        }

        @Override
        public PersonProfileDto getProfile(String id) throws UserException {
            var entity=_personRepo.findDistinctByUserId(id);
            if (entity.isEmpty()){
                log.error("user not exists with id "+id);
                throw  new UserException("کاربری با این مشخصات وجود ندارد");
            }

            var dto=new PersonProfileDto();
            BeanUtils.copyProperties(entity.get(),dto);
            return  dto;
        }

        @Override
        public boolean authenticate(String email, String password){
            boolean result=_personRepo.existsByEmailAndPassword(email,password);
            return result;

        }

        @Override
        public boolean isExists(String email){
            boolean result=_personRepo.existsByEmail(email);
            return result;

        }

        @Override
        public int update(ProfileUpdateDto dto) throws UserException {
            var entity=_personRepo.findDistinctByUserId(dto.getUserId());
            if (entity.isEmpty()){
                log.error("try to update non-exists user with id  "+dto.getPersonId());
                throw  new UserException("کاربری با این مشخصات وجود ندارد");
            }

            var et=entity.get();
            BeanUtils.copyProperties(dto,entity.get());
            entity.get().setLastLoginAt(Utils.getUtc());
            _personRepo.save(et);
            return 1;
        }


        @Override
        public int updatePassword(UpdatePassDto dto) throws UserException {
            var entity=_personRepo.findById(dto.getPersonId());
            if (entity.isEmpty()){
                log.error("try to update non-exists user with id  "+dto.getPersonId());
                throw  new UserException("کاربری با این مشخصات وجود ندارد");
            }
            var et=entity.get();
            if (et.getPassword().equals(dto.getOldPass()))
            {
                et.setLastLoginAt(Utils.getUtc());
                et.setPassword(dto.getNewPass());
                _personRepo.save(et);
                return 1;
            }
            return 0;
        }

        @Override
        public String register(String email) throws UserException {

                        //check this email exists
                        boolean isExists=_personRepo.existsByEmail(email);
                        if (isExists){
                            log.error("duplicate register request with"+email);
                            throw  new UserException("این ایمیل قبلا ثبت شده است");
                        }

            String pass=Utils.getRandomString(6);
                        String username=Utils.getRandomString(10);
            //int photoId = (int) Math.floor(Math.random() * (800 - 200 + 1) + 200);
            String photoUri="https://picsum.photos/"+200;
            var entity=new Person().builder().email(email).fcm("")
                    .fullName("unknown")
                    .isPremium(false)
                    .lastLoginAt(Utils.getUtc())
                    .registerAt(Utils.getUtc())
                    .password(pass)
                    .photoUri(photoUri)
                    .roleId(1)
                    .token("")
                    .userId(username)
                    .refreshToken("")
                    .build();
            _personRepo.save(entity);
            return username;
        }

    }
}
