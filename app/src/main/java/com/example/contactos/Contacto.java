package com.example.contactos;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Contacto implements Parcelable {
    String usuario, email, twitter, telefono, fechaNac;

    public Contacto(){}

    public Contacto(String usuario, String email, String twitter, String telefono, String fechaNac) {
        this.usuario = usuario;
        this.email = email;
        this.twitter = twitter;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }

    protected Contacto(Parcel in) {
        usuario = in.readString();
        email = in.readString();
        twitter = in.readString();
        telefono = in.readString();
        fechaNac = in.readString();
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(usuario);
        parcel.writeString(email);
        parcel.writeString(twitter);
        parcel.writeString(telefono);
        parcel.writeString(fechaNac);
    }
}
