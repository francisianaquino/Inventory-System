package hau.edu.ph.ObprogL.service;

import hau.edu.ph.ObprogL.model.Shirt;
import hau.edu.ph.ObprogL.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService {

    @Autowired
    private ShirtRepository shirtRepository;

    public List<Shirt> findAllShirts() {
        return shirtRepository.findAll();
    }

    public Shirt addShirt(Shirt shirt) {
        return shirtRepository.save(shirt);
    }

    public Shirt findShirt(Integer id) {
        if(shirtRepository.existsById(id))
            return shirtRepository.getOne(id);
        throw new NullPointerException("no data found at id " + id);
    }

    public Shirt updateShirt(Integer id, Shirt shirt) {
        if(shirtRepository.existsById(id)) {
            shirt.setId(id);
            return shirtRepository.save(shirt);
        } throw new NullPointerException("trying to update a non-existing data at id " + id);
    }

    public Boolean deleteShirt(Integer id) {
        if(shirtRepository.existsById(id)) {
            shirtRepository.deleteById(id);
            return true;
        } throw new NullPointerException("trying to delete a non-existing data at id " + id);
    }
}
