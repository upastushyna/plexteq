package ua.danit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.danit.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {
}
