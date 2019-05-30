package com.billingengine.contractledger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMRepository extends JpaRepository<TestMParent, Long> {

//    Long deleteByName(String name);
//
//    List<TestM> deleteByColor(String color);
//
//    Long removeByName(String name);
//
//    List<TestM> removeByColor(String color);
//
//    @Modifying
//    @Query("delete from Fruit f where f.name=:name or f.color=:color")
//    List<TestM> deleteFruits(@Param("name") String name, @Param("color") String color);
}
