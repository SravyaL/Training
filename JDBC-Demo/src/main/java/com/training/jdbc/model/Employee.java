package com.training.jdbc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="employees")
public class Employee {
    

            @Id
            @GeneratedValue(strategy=GenerationType.AUTO)
            private long id;
            
            @NotEmpty(message="Name cannot be empty.")
            @Size(min=5, max=15, message="Name must be over 5 and under 15 characters.")
            private String name;
            
            
            @NotNull(message="Salary cannot be empty.")
            private double salary;
                        
            @DateTimeFormat(iso = ISO.DATE)
            @NotNull(message="Date Of Joining cannot be left blank.")
            private LocalDate dateOfJoining;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            public LocalDate getDateOfJoining() {
                return dateOfJoining;
            }

            public void setDateOfJoining(LocalDate dateOfJoining) {
                this.dateOfJoining = dateOfJoining;
            }

            @Override
            public String toString() {
                return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfJoining="
                        + dateOfJoining + "]";
            }
                    
                    
}

