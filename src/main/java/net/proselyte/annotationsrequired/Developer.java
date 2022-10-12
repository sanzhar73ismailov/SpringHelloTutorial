package net.proselyte.annotationsrequired;

import org.springframework.beans.factory.annotation.Required;

public class Developer {
    private String name;
    private Integer experience;
    private String speciality;

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public Integer getExperience() {
        return experience;
    }

    @Required
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Required
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
