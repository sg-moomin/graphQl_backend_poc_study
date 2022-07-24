


package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import repository.userRepository;


@Service
@RequiredArgsConstructor
@Component
public class userQuery {

    @Autowired
    private userRepository userRepositorys;

    // 모든 유저 검색
    public DataFetcher<?> allUser(){
        return environment -> {
            return userRepositorys.findAll();
        };
    }

    public DataFetcher<?> findUser(){
        return environment ->{
            String id = environment.getArgument("userId");
            return userRepositorys.findById(id);
            // return userRepositorys.findById(userId);
        };
    }
}