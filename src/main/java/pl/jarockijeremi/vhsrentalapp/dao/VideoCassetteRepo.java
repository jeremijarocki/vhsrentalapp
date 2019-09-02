package pl.jarockijeremi.vhsrentalapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jarockijeremi.vhsrentalapp.dao.entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository <VideoCassette, Long> {

}
