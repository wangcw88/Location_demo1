package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

   List<User> findByUsernameAndPassword(String username, String password);
   User findByUsername(String username);

//   @Query(value = "update User set lat=?1 and lng =?2 where username=?3 ", nativeQuery = true)
//   @Modifying
//   public void update(String lat, String lng, String username);




}
