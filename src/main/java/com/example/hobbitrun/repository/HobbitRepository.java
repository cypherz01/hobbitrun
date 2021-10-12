package com.example.hobbitrun.repository;

import com.example.hobbitrun.model.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    superpowers:
    - DAO implementation (covered by spring Data)
    - no need to implement anything, in case extending is not enough:
        - use @Query
        -implement DAO on your own

    - myRepositiory extends RepositoryInterfaceFromSpringData<EntityClass, PrimaryKeyInEntityClass>
 */

public interface HobbitRepository extends JpaRepository<Hobbit,Long> {


}
