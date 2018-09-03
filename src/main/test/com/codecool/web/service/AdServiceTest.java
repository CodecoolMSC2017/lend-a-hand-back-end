package service;

import com.codecool.web.model.Ad;
import com.codecool.web.model.User;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.NotificationRepository;
import com.codecool.web.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AdServiceTest {

    @Autowired
    private AdService adService;
    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Before
    public void setUp() {

        final String pending = "Pending";

        //*****
        //USERS
        //*****
        User steven13 = new User("steven13@gmail.com", "steven13", "steven13");
        User bob = new User("bob@gmail.com", "bob", "bob48");
        User duckFace = new User("duckFace@gmail.com", "duckFace", "duckFace");
        User orangeKilla = new User("orangeKilla13@gmail.com", "orangeKilla", "orangeKilla56");

        LocalDateTime localDateTime = (new Timestamp(new Date().getTime()).toLocalDateTime());

        //*****
        //ADS
        //*****
        Ad BabysittingEverday = new Ad(steven13, "Babysitting everday", "I can care for you child everyday 24/7", "Child care", false, localDateTime, "Hand-lending", "Pending");
        Ad HTMLProgrammer = new Ad(steven13, "HTML programmer", "I am a hackerman, I code HTML, I know you need me!", "IT", true, localDateTime, "Hand-lending", "Completed");
        Ad GardeningMowing = new Ad(bob, "Gardening mowing outdoor solutions", "Hi, We are a team of 2 professional Gardeners! Contact us today to get a free quotation!", "Garden", true, localDateTime, "Hand-lending", "Pending");
        Ad BuilderAndPlasterer = new Ad(duckFace, "Builder and Plasterer", "Experienced Builder and Plasterer Specializing in Restoration. Providing quality work and excellent customer service.", "Construction", true, localDateTime, "Hand-lending", "Pending");
        Ad YoungBabysitter = new Ad(orangeKilla, "Young babysitter", "Hi! I am Jemma, 22 years old. I love children so much. I am responsible.", "Child care", false, localDateTime, "Hand-lending", "Pending");
        Ad PlasteringAndRendering = new Ad(bob, "Plastering & Rendering", "We Provide all services to do with plastering and rendering across the Staffordshire area.", "Construction", true, localDateTime, "Hand-lending", "Pending");

        //*****
        //Lists
        //*****
        List<Ad> all = new ArrayList<>(Arrays.asList(BabysittingEverday, HTMLProgrammer, GardeningMowing, BuilderAndPlasterer, YoungBabysitter, PlasteringAndRendering));
        List<Ad> allPending = new ArrayList<>(Arrays.asList(BabysittingEverday, GardeningMowing, BuilderAndPlasterer, YoungBabysitter, PlasteringAndRendering));
        List<Ad> empty = new ArrayList<>();
        List<Ad> stevensAds = new ArrayList<>(Arrays.asList(BabysittingEverday, HTMLProgrammer));
        List<Ad> childCare = new ArrayList<>(Arrays.asList(BabysittingEverday, YoungBabysitter));


        //getAllForAdmin()
        Mockito.when(adRepository.findAllByOrderByIsPremiumDescTimestampDesc()).thenReturn(all);

        //getAll()
        Mockito.when(adRepository.findAllByStateOrderByIsPremiumDescTimestampDesc("Pending")).thenReturn(allPending);

        //getAllByAdvertiserId()
        Mockito.when(adRepository.findAllByStateAndAdvertiser_IdOrderByIsPremiumDescTimestampDesc(pending, 1)).thenReturn(stevensAds);
        Mockito.when(adRepository.findAllByStateAndAdvertiser_IdOrderByIsPremiumDescTimestampDesc(pending, 5)).thenReturn(empty);

        //getById()
        Mockito.when(adRepository.findById(1)).thenReturn(BabysittingEverday);
        Mockito.when(adRepository.findById(8)).thenReturn(null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllForAdmin() {
        assertEquals(6, adService.getAllForAdmin().size());
    }

    @Test
    public void getAll() {
        assertEquals(5, adService.getAll().size());
    }

    @Test
    public void getAllByAdvertiserIdWithValidInput() {
        assertEquals(2, adService.getAllByAdvertiserId(1).size());
    }

    @Test
    public void getAllByAdvertiserIdWithInValidInput() {
        assertEquals(0, adService.getAllByAdvertiserId(5).size());
    }

    @Test
    public void getByIdWithValidInput() {
        assertEquals("Babysitting everday", adService.getById(1).getTitle());
    }

    @Test
    public void getByIdWithInValidInput() {
        assertEquals(null, adService.getById(8));
    }

    @Test
    public void getAllByFilter() {
    }

    @Test
    public void blockAd() {
    }

    @Test
    public void setPremiumToTrue() {
    }

    @Test
    public void addNewAd() {
    }

    @Test
    public void deleteAd() {
    }

    @Test
    public void updateAdData() {
    }

    @Configuration
    static class adServiceTestConfiguration {
        @Bean
        public AdService adService() {
            return new AdService();
        }

        @Bean
        public AdRepository adRepository() {
            return Mockito.mock(AdRepository.class);
        }

        @Bean
        public UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }

        @Bean
        public NotificationRepository notificationRepository() {
            return Mockito.mock(NotificationRepository.class);
        }
    }
}
