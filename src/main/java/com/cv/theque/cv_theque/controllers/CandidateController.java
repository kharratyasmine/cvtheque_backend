package com.cv.theque.cv_theque.controllers;


import com.cv.theque.cv_theque.models.CV;
import com.cv.theque.cv_theque.models.CVContent;
import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Formation;
import com.cv.theque.cv_theque.services.CandidateService;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/candidate")
@CrossOrigin("*")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping()
    public List<Candidate> findAllByDeletedIsFalse() {
        List<Candidate> candidateList = candidateService.findAllByDeletedIsFalse();
        candidateList.forEach(candidate -> candidate.setCv(""));
        return candidateList;
    }

    private void writeToFile(byte[] bytes) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/resources/cv.pdf", true);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    @GetMapping("cv/{id}")
    public CV findCvByCandidateId(@PathVariable Long id) {
        CV currentCv = new CV();
        currentCv.setCv(candidateService.findCvByCandidateId(id));
        return currentCv;
    }

    @PostMapping("parsing")
    public CVContent parsePDF(@RequestBody String base64) throws IOException {
        String content = null;
        try {

            byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(base64.getBytes());
            writeToFile(decoded);

            //instance pdfreader
            PdfReader pdf = new PdfReader("C:\\Users\\skanoun\\CVThèque\\cvtheque_backend\\src\\main\\resources\\cv.pdf");

            //nb de page pdf
            int nbrPages = pdf.getNumberOfPages();

            //iterer le pdf a travers les pages
            for (int i = 1; i <= nbrPages; i++) {
                // extraire le contenu
                content += PdfTextExtractor.getTextFromPage(pdf, i);
            }

            //fermer pdf reader
            pdf.close();
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        System.out.println(content);
        CVContent cvContent = new CVContent();
        if (content != null) {
            boolean lastForamtion = true;
            BufferedReader bufReader = new BufferedReader(new StringReader(content));
            String line;
            String competence;
            Formation formation = new Formation();
            List<String> experiences = new ArrayList<>();
            List<String> competences = new ArrayList<>();
            while ((line = bufReader.readLine()) != null) {
                int position = line.indexOf(":");
                if (position > 0) {
                    if (line.toLowerCase().contains("nom :") || line.toLowerCase().contains("last name :")) {
                        String value = line.substring(position + 1);
                        cvContent.setNom(value.trim());
                    }
                    if (line.toLowerCase().contains("prenom :") || line.toLowerCase().contains("first name :")) {
                        String value = line.substring(position + 1);
                        cvContent.setPrenom(value.trim());
                    }
                    if (line.toLowerCase().contains("date de naissance :") || line.toLowerCase().contains("date of birth :")) {
                        String value = line.substring(position + 1);
                        cvContent.setDateNaissance(value.trim());
                    }
                    if (line.toLowerCase().contains("phone :")) {
                        String value = line.substring(position + 1);
                        cvContent.setTelephone(value.trim());
                    }
                    if (line.toLowerCase().contains("adresse e-mail :") || line.toLowerCase().contains("mail address :")) {
                        String value = line.substring(position + 1);
                        cvContent.setMail(value.trim());
                    }
                    if (line.toLowerCase().contains("periode :") || line.toLowerCase().contains("period :")) {
                        String value = line.substring(position + 1);
                        experiences.add(value.trim());
                        cvContent.setExperiences(experiences);
                    }
                    if (line.toLowerCase().contains("date diplome :")&& lastForamtion || line.toLowerCase().contains("graduation date :")&& lastForamtion) {
                        String value = line.substring(position + 1);
                        formation.setDateDiplome(value.trim());
                    }
                    if (line.toLowerCase().trim().startsWith("diplome :") && lastForamtion || line.toLowerCase().trim().startsWith("diploma :") && lastForamtion) {
                        String value = line.substring(position + 1);
                        formation.setNameDiplome(value.trim());
                        lastForamtion = false;
                        cvContent.setFormation(formation);
                    }
                    if (line.toLowerCase().contains("competences :") || line.toLowerCase().contains("skills :")) {
                        while ((competence = bufReader.readLine()) != null) {
                            if (competence.toLowerCase().contains("activites :") || competence.toLowerCase().contains("activities :")  ) {
                                break;
                            }
                            if (!competence.equals(" ")) {
                                competences.add(competence.trim());
                                cvContent.setCompetences(competences);
                            }
                        }
                    }
                }
            }
        }
        return cvContent;
    }


    @PostMapping()
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);
    }

    @PutMapping("{id}")
    public Candidate putCandidate(@RequestBody Candidate candidate, @PathVariable Long id) {
        return candidateService.putCandidate(candidate, id);
    }

    @DeleteMapping("{id}")
    public Candidate putCandidate(@PathVariable Long id) {
        return candidateService.deleteCandidate(id);
    }

    @GetMapping("{id}")
    public Candidate findCandidateById(@PathVariable Long id) {
        return candidateService.findCandidateById(id);
    }

    @PostMapping("email/{sequence}/{post}")
    public void sendMail(@RequestBody Candidate candidate, @PathVariable String sequence, @PathVariable String post, @Param("date") String date, @Param("heure") String heure, @Param("type") String type) throws MessagingException {
        candidateService.sendmail(candidate, sequence, post, date, heure, type);
    }
}
