package logica.modelo;

import java.sql.Date;

public class Reservacion {

    private Integer id_reservation;
    private Date date_of_entry;
    private Date date_of_exit;
    private float value_stay_price;
    private String form_payment;
    private float total;
    private Boolean is_active;

    public Reservacion(Date date_of_entry, Date date_of_exit, float value_stay_price, String form_payment, float total) {
        this.date_of_entry = date_of_entry;
        this.date_of_exit = date_of_exit;
        this.value_stay_price = value_stay_price;
        this.form_payment = form_payment;
        this.total = total;
    }

    public Reservacion(Integer id_reservation, Date date_of_entry, Date date_of_exit, float value_stay_price, String form_payment) {
        this.id_reservation = id_reservation;
        this.date_of_entry = date_of_entry;
        this.date_of_exit = date_of_exit;
        this.value_stay_price = value_stay_price;
        this.form_payment = form_payment;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Date getDate_of_entry() {
        return date_of_entry;
    }

    public void setDate_of_entry(Date date_of_entry) {
        this.date_of_entry = date_of_entry;
    }

    public Date getDate_of_exit() {
        return date_of_exit;
    }

    public void setDate_of_exit(Date date_of_exit) {
        this.date_of_exit = date_of_exit;
    }

    public float getValue_stay_price() {
        return value_stay_price;
    }

    public void setValue_stay_price(float value_stay_price) {
        this.value_stay_price = value_stay_price;
    }

    public String getForm_payment() {
        return form_payment;
    }

    public void setForm_payment(String form_payment) {
        this.form_payment = form_payment;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
