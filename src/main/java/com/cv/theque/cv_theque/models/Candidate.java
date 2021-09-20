package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity()
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="candidate", scope = Candidate.class)
public class Candidate extends Auditable<String>  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long candidate_id;
    @OneToMany(mappedBy = "candidate")
    private List<Candidature> candidatures;
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Candidate_Advantage> Candidate_Advantage;
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Candidate_Competence> Candidate_Competence;
    private String last_name;
    private String first_name;
    private String gender;
    private String birth_date;
    private String mail;
    private String identity;
    private String tel_fix;
    private String tel_mobile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diploma_id", nullable = false)
    @JsonIgnoreProperties(value = {"candidate", "hibernateLazyInitializer"})
    private Diploma diploma;
    private String diploma_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    @JsonIgnoreProperties(allowSetters = true, value = {"candidate", "hibernateLazyInitializer"})
    private University university;
    private int nb_experience;
    private String ex_employers;
    private String last_position;
    private String motivation;
    private String cv;

    public List<com.cv.theque.cv_theque.models.Candidate_Advantage> getCandidate_Advantage() {
        return Candidate_Advantage;
    }

    public void setCandidate_Advantage(List<com.cv.theque.cv_theque.models.Candidate_Advantage> candidate_Advantage) {
        Candidate_Advantage = candidate_Advantage;
    }

    public List<com.cv.theque.cv_theque.models.Candidate_Competence> getCandidate_Competence() {
        return Candidate_Competence;
    }

    public void setCandidate_Competence(List<com.cv.theque.cv_theque.models.Candidate_Competence> candidate_Competence) {
        Candidate_Competence = candidate_Competence;
    }

    public String getCv() {
        return cv;
    }
    public void setCv(String cv) {
        this.cv = cv;
    }


    public long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel_fix() {
        return tel_fix;
    }

    public void setTel_fix(String tel_fix) {
        this.tel_fix = tel_fix;
    }

    public String getTel_mobile() {
        return tel_mobile;
    }

    public void setTel_mobile(String tel_mobile) {
        this.tel_mobile = tel_mobile;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public void setDiploma(Diploma diploma) {
        this.diploma = diploma;
    }

    public String getDiploma_date() {
        return diploma_date;
    }

    public void setDiploma_date(String diploma_date) {
        this.diploma_date = diploma_date;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public int getNb_experience() {
        return nb_experience;
    }

    public void setNb_experience(int nb_experience) {
        this.nb_experience = nb_experience;
    }

    public String getEx_employers() {
        return ex_employers;
    }

    public void setEx_employers(String ex_employers) {
        this.ex_employers = ex_employers;
    }

    public String getLast_position() {
        return last_position;
    }

    public void setLast_position(String last_position) {
        this.last_position = last_position;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }


    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }

    public Candidate() {
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidate_id=" + candidate_id +
                ", candidatures=" + candidatures +
                ", Candidate_Advantage=" + Candidate_Advantage +
                ", Candidate_Competence=" + Candidate_Competence +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", mail='" + mail + '\'' +
                ", identity='" + identity + '\'' +
                ", tel_fix='" + tel_fix + '\'' +
                ", tel_mobile='" + tel_mobile + '\'' +
                ", diploma=" + diploma +
                ", diploma_date='" + diploma_date + '\'' +
                ", university=" + university +
                ", nb_experience=" + nb_experience +
                ", ex_employers='" + ex_employers + '\'' +
                ", last_position='" + last_position + '\'' +
                ", motivation='" + motivation + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}
