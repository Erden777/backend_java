package KinoPoisk.demo.services;

import KinoPoisk.demo.entities.Actors;

import java.util.List;


public interface ActorService {

    Actors addActors(Actors actors);
    List<Actors> getAllActors();
    Actors getActor(Long id);
    void deleteActors(Actors actors);
}
