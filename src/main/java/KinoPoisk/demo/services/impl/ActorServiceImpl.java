package KinoPoisk.demo.services.impl;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.repositories.ActorRepository;
import KinoPoisk.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actors addActors(Actors actors) {
        return actorRepository.save(actors);
    }

    @Override
    public List<Actors> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actors getActor(Long id) {
        return actorRepository.getOne(id);
    }

    @Override
    public void deleteActors(Actors actors) {
        actorRepository.delete(actors);
    }
}
