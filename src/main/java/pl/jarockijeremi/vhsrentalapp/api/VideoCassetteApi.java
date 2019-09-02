package pl.jarockijeremi.vhsrentalapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jarockijeremi.vhsrentalapp.dao.entity.VideoCassette;
import pl.jarockijeremi.vhsrentalapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/list")
public class VideoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videoCassettes.findById(index);
    }

    @PostMapping
    public VideoCassette addVhs(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.addVideoCassette(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVhs(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.addVideoCassette(videoCassette);
    }

    @DeleteMapping
    public void deleteVhs(@RequestParam Long index) {
        videoCassettes.deleteById(index);
    }
}
