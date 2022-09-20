


package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import repository.userRepository;


@Component
public class userDataFetcher {

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
            // return userRepositorys.findById(id);
            return userRepositorys.findByUserId(id);
        };
    }
}