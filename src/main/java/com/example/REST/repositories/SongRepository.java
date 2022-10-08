package com.example.REST.repositories;

import com.example.REST.models.Song;
import com.example.REST.models.SongDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {

    static Long currentId = 5L;

    private final List<Song> songs = new LinkedList<>(Arrays.asList(
            new Song(1L, "Yellow", "Coldplay", 2004),
            new Song(2L, "Thriller", "Michael Jackson", 1982),
            new Song(3L, "Początek", "Męskie Granie Orkiestra", 2020),
            new Song(4L, "Nothing else matters", "Metallica", 1980)
    ));


    public List<Song> getAll() {
        return songs;
    }

    public Optional<Song> get(Long id) {
        return songs.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    public Song create(SongDto songDto) {
        Song newSong = new Song(currentId++, songDto);
        songs.add(newSong);
        return newSong;
    }

    public Song update(Song song, SongDto songDto) {
        song.setAuthor(songDto.getAuthor());
        song.setTitle(songDto.getTitle());
        songDto.setYear(songDto.getYear());
        return song;
    }

    public void delete(Song song) {
        songs.remove(song);
    }
}
