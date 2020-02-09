package com.synerzip.docker.training.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.docker.training.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

}
