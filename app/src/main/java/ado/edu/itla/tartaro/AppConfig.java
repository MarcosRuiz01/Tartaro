package ado.edu.itla.tartaro;

import ado.edu.itla.tartaro.entidad.Usuario;

public class AppConfig {

    private static  AppConfig APP_CONFIG;
    private Usuario usuario;

    private AppConfig(){

    }

    public static AppConfig getConfig(){
        if (APP_CONFIG ==null){
            APP_CONFIG = new AppConfig();
        }
        return APP_CONFIG;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
