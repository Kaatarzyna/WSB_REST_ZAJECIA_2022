package com.example.REST.services;

import com.example.REST.exceptions.ResourceNotFoundException;
import com.example.REST.models.Song;
import com.example.REST.models.SongDto;
import com.example.REST.repositories.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public List<Song> getAll() {
        return songRepository.getAll();
    }

    public Song get(Long id) {
        return songRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Song create(SongDto songDto) {
        return songRepository.create(songDto);
    }

    public Song update(Long id, SongDto songDto) {
        Song song = get(id);
        return songRepository.update(song, songDto);
    }

    public void delete(Long id) {
        Song song = get(id);
        songRepository.delete(song);
    }

}
