package pl.jarockijeremi.vhsrentalapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.jarockijeremi.vhsrentalapp.dao.VideoCassetteRepo;
import pl.jarockijeremi.vhsrentalapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette addVideoCassette(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        addVideoCassette(new VideoCassette(1L, "Masakra", LocalDate.of(1999, 1, 23)));
        addVideoCassette(new VideoCassette(2L, "Kukułcze gniazdo", LocalDate.of(1979, 5, 1)));
    }
}
