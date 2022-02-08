package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.repositories.CandidateRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.text.DateFormatter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final SpringTemplateEngine templateEngine;
    private final JavaMailSender sender;

    public CandidateService(CandidateRepository candidateRepository, SpringTemplateEngine templateEngine, JavaMailSender sender) {
        this.candidateRepository = candidateRepository;
        this.templateEngine = templateEngine;
        this.sender = sender;
    }

    public List<Candidate> findAllByDeletedIsFalse() {
        return candidateRepository.findAllWithoutCV();
    }

    public String findCvByCandidateId(long id) {
        return candidateRepository.findCvByCandidateId(id);
    }

    public Candidate putCandidate(Candidate candidate, Long id) {
        candidate.setCandidate_id(id);
        return candidateRepository.save(candidate);
    }

    public Candidate deleteCandidate(Long id) {
        Candidate candidate = findCandidateById(id);
        candidate.setDeleted(true);
        return putCandidate(candidate, id);
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate findCandidateById(Long id) {
        return candidateRepository.findById(id).get();
    }


    public void sendmail(Candidate candidate, String sequence, String post, String date, String heure, String type) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Map<String, Object> model = new HashMap<>();
        model.put("name", candidate.getFirst_name());
        model.put("gender", candidate.getGender());
        model.put("last_name", candidate.getLast_name());
        model.put("email", candidate.getMail());
        model.put("typeEntretien", sequence);
        model.put("post_name", post);
        model.put("date", date);
        model.put("heure" , heure);
        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process(type, context);

        try {
            helper.setTo(candidate.getMail());
            helper.setText(html, true);
            helper.setSubject(sequence);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
}


