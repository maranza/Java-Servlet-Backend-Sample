package tk.xdevcloud.medicalcore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "patients")
public class Patient {
    @Expose(deserialize = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "id_number")
    private String IdNumber;

    public Patient(String firstName, String lastName, String IdNumber) {


        this.firstName = firstName;
        this.lastName = lastName;
        this.IdNumber = IdNumber;
    }


    public Patient() {
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setIdNumber(String IdNumber) {

        this.IdNumber = IdNumber;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public String getIdNumber() {

        return this.getIdNumber();
    }

}
