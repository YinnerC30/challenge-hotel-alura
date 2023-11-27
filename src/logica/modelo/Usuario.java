package logica.modelo;

public class Usuario {
    private Integer id_user;
    private String name;
    private String last_name;
    private String password;
    private Boolean is_active;

    // Otros metodos

    public Usuario(String name, String last_name, String password) {
        this.name = name;
        this.last_name = last_name;
        this.password = password;

    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
