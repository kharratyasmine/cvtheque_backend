package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Advantage;
import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Post;
import com.cv.theque.cv_theque.repositories.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementrepository;

    public AnnouncementService(AnnouncementRepository announcementrepository) {
        this.announcementrepository = announcementrepository;
    }

    public List<Announcement> findAllAnnouncements() {
        return announcementrepository.findAllByDeletedIsFalse();
    }

    public  List<Announcement> findOneByPost(Post post) {
        return announcementrepository.findByPost(post);
    }

    public Announcement putAnnouncement(Announcement announcement, Long id) {
        announcement.setId_announcement(id);
        return announcementrepository.save(announcement);
    }

    public Announcement deleteAnnouncement(Long id) {
        Announcement announcement = findAnnouncementById(id);
        announcement.setDeleted(true);
        return putAnnouncement(announcement, id);
    }

    public Announcement addAnnouncement(Announcement announcement) {
        return announcementrepository.save(announcement);
    }

    public Announcement findAnnouncementById(Long id) {
        return announcementrepository.findById(id).get();
    }
}

