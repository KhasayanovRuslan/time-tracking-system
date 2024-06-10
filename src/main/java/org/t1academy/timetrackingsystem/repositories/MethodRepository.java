package org.t1academy.timetrackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.t1academy.timetrackingsystem.model.Method;

import java.util.List;
import java.util.Optional;

@Repository
public interface MethodRepository extends JpaRepository<Method, Long> {

    @Query("SELECT m FROM Method m")
    List<Method> findAllMethods();

    Optional<Method> findByClassNameAndMethodName(String className, String methodName);

    Method findMethodByMethodName(@Param("methodName") String methodName);

    @Query("SELECT m.methodName FROM Method m")
    List<String> findAllMethodNames();

}
