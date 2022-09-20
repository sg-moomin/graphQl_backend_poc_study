package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.userEntity;

@Repository
public interface userRepository extends JpaRepository<userEntity, String>{
    userEntity findByUserId(String userId);
}