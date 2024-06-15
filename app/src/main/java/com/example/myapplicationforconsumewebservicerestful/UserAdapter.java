package com.example.myapplicationforconsumewebservicerestful;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(
                "ID: " + user.getId() + "\n" +
                        "Nombre: " + user.getNombre() + "\n" +
                        "Apellido Paterno: " + user.getApellidoPaterno() + "\n" +
                        "Apellido Materno: " + user.getApellidoMaterno() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Género: " + user.getGenero() + "\n" +
                        "Fecha de Nacimiento: " + user.getFechaNacimiento() + "\n" +
                        "Edad: " + user.getEdad() + "\n" +
                        "Email Verificado: " + user.getEmailVerifiedAt() + "\n" +
                        "Creado en: " + user.getCreatedAt() + "\n" +
                        "Actualizado en: " + user.getUpdatedAt()
        );

        return convertView;
    }
}
