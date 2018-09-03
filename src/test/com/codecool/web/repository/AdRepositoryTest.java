package com.codecool.web.repository;

import com.codecool.web.Application;
import com.codecool.web.model.Ad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
public class AdRepositoryTest {

    @Autowired
    private AdRepository adRepository;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
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

    @org.junit.Test
    public void findById() {
        Ad found = adRepository.findById(1);
        assertEquals("Looking for babysitterNew", found.getTitle());
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
