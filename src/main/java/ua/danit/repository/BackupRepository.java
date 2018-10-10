package ua.danit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.danit.entity.Backup;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long> {
}