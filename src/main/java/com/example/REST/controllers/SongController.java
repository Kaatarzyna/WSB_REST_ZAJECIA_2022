package com.example.REST.controllers;

import com.example.REST.models.Song;
import com.example.REST.models.SongDto;
import com.example.REST.services.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
@AllArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    List<Song> getAll() {
        return songService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<Song> get(@PathVariable Long id) {
        return ResponseEntity.ok(songService.get(id));
    }

    @PostMapping
    ResponseEntity<Song> create(@RequestBody SongDto songDto) {
        Song song = songService.create(songDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(song);
    }

    @PutMapping("{id}")
    ResponseEntity<Song> update(@PathVariable Long id, @RequestBody SongDto songDto) {
        return ResponseEntity.ok(songService.update(id, songDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
