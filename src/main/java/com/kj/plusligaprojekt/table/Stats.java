package com.kj.plusligaprojekt.table;

import com.kj.plusligaprojekt.team.Team;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer gainedPoints;
    private Integer lostPoints;
    private Integer gainedSets;
    private Integer lostSets;
    private Integer totalPoints;

    @OneToMany(mappedBy = "stats")
    List<Team> teams;

    public Stats() {
        this.gainedPoints = 0;
        this.lostPoints = 0;
        this.gainedSets = 0;
        this.lostSets = 0;
        this.totalPoints = 0;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(Integer gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    public Integer getLostPoints() {
        return lostPoints;
    }

    public void setLostPoints(Integer lostPoints) {
        this.lostPoints = lostPoints;
    }

    public Integer getGainedSets() {
        return gainedSets;
    }

    public void setGainedSets(Integer gainedSets) {
        this.gainedSets = gainedSets;
    }

    public Integer getLostSets() {
        return lostSets;
    }

    public void setLostSets(Integer lostSets) {
        this.lostSets = lostSets;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
