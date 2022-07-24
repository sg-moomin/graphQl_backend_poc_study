package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, String>{
    
}