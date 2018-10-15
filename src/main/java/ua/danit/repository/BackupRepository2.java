package ua.danit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.danit.entity2.Backup2;
import ua.danit.entity2.User2;

public interface BackupRepository2  extends MongoRepository<Backup2, String> {
}
