package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Registrants {
    
    @NotBlank(message = "Required field.")
    @Size(min=5, max=25, message ="Requres 5-25 characters input.")
    private String fullName;
    
    @NotBlank(message = "Required field.")
    @Past
    private Date birthDate;

    @NotBlank(message = "Required field.")
    @Email(message = "Not a valid email.")
    @Size(max=50, message = "Do not exceed 50 characters.")
    private String email;

    @NotBlank(message = "Required field.")
    @Pattern(regexp = "[0-9]{8}", message = "Phone must be 8 digits")
    private String phoneNo;

    @NotBlank(message = "Required field.")
    @Min(value = 1, message = "Minimum of 1 ticket required.")
    @Max(value = 3, message = "Maximum of 3 tickets allowed.")
    private Integer tickets;

    private String gender;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Registrants() {
    }

    public Registrants(
            @NotBlank(message = "Required field.") @Size(min = 5, max = 25, message = "Requres 5-25 characters input.") String fullName,
            @NotBlank(message = "Required field.") @Past Date birthDate,
            @NotBlank(message = "Required field.") @Email(message = "Not a valid email.") @Size(max = 50, message = "Do not exceed 50 characters.") String email,
            @NotBlank(message = "Required field.") @Pattern(regexp = "[0-9]{8}", message = "Phone must be 8 digits") String phoneNo,
            @NotBlank(message = "Required field.") @Min(value = 1, message = "Minimum of 1 ticket required.") @Max(value = 3, message = "Maximum of 3 tickets allowed.") Integer tickets,
            String gender) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNo = phoneNo;
        this.tickets = tickets;
        this.gender = gender;
    }

    
}
