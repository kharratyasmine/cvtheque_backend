package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Post;
import com.cv.theque.cv_theque.services.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/announcement")
@CrossOrigin("*")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping()
    public List<Announcement> findAllAnnouncements() {
        return announcementService.findAllAnnouncements();
    }

    @PostMapping("post")
    public Announcement findByPost(@RequestBody Post post) {
        return announcementService.findOneByPost(post);
    }

    @PostMapping()
    public Announcement addAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.addAnnouncement(announcement);
    }

    @PutMapping("{id}")
    public Announcement putAnnouncement(@RequestBody Announcement announcement, @PathVariable Long id) {
        return announcementService.putAnnouncement(announcement, id);
    }

    @DeleteMapping("{id}")
    public Announcement putAnnouncement(@PathVariable Long id) {
        return announcementService.deleteAnnouncement(id);
    }

    @GetMapping("{id}")
    public Announcement findAnnouncementById(@PathVariable Long id) {
        return announcementService.findAnnouncementById(id);
    }
}

