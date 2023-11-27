package logica.modelo;

import java.sql.Date;

public class Cliente {
    private Integer id_client;
    private String name;
    private String last_name;
    private Date date_of_birth;
    private String nacionality;
    private String telephone;

    private Integer id_reservation;
    private Boolean is_active;

    // Otros metodos




    public Cliente(String name, String last_name, Date date_of_birth, String nacionality, String telephone, Integer id_reservation) {
        this.name = name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.nacionality = nacionality;
        this.telephone = telephone;
        this.id_reservation=id_reservation;
    }



    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }
}
