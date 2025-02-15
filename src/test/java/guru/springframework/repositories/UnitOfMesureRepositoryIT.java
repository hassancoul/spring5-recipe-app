package guru.springframework.repositories;

import guru.springframework.models.UnitOfMesure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMesureRepositoryIT {

    @Autowired
    UnitOfMesureRepository unitOfMesureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUnit() {

        Optional<UnitOfMesure> unitOptional = unitOfMesureRepository.findByUnit("Teaspoon");

        assertEquals("Teaspoon", unitOptional.get().getUnit());
    }

    @Test
    public void findByUnitCup() {

        Optional<UnitOfMesure> unitOptional = unitOfMesureRepository.findByUnit("Cup");

        assertEquals("Cup", unitOptional.get().getUnit());
    }
}