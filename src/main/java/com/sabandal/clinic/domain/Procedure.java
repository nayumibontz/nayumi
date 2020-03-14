package com.sabandal.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "procedure")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Procedure implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private Long procedureId;

    @Column(name = "procedure_name")
    private String procedureName;

    @Column(name = "procedure_detail")
    private String procedureDetail;

    @Column(name = "price")
    private float price;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "procedure")
    private List<Appointment> appointment;

    public Long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Long procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureDetail() {
        return procedureDetail;
    }

    public void setProcedureDetail(String procedureDetail) {
        this.procedureDetail = procedureDetail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

//    public void setAppointment(Appointment appointment) {
//        this.appointment = appointment;
//    }

//    public List<Appointment> getAppointment() {
//        return appointment;
//    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureName='" + procedureName + '\'' +
                ", procedureDetail='" + procedureDetail + '\'' +
                ", price=" + price +
                '}';
    }
}
