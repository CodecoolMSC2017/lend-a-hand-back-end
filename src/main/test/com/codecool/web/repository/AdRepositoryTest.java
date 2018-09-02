package com.codecool.web.repository;

import com.codecool.web.model.Ad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static junit.framework.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdRepositoryTest {

    @Autowired
    private AdRepository adRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }

    @Test
    public void findAllByStateOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndAdvertiser_IdOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findById() {
        Ad found = adRepository.findById(1);
        assertEquals("Looking for babysitter", found.getTitle());

    }

    @Test
    public void findAllByStateAndCategoryOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndTitleContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndDescriptionContainingIgnoreCaseOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndTypeOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndTitleContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndDescriptionContainingIgnoreCaseAndCategoryOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndTitleContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndDescriptionContainingIgnoreCaseAndTypeOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndTitleContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc() {
    }

    @Test
    public void findAllByStateAndDescriptionContainingIgnoreCaseAndCategoryAndTypeOrderByIsPremiumDescTimestampDesc() {
    }
}
