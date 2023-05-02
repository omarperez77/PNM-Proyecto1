package edu.tecmm.bytebuilders.foodservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.auth.User;

import java.util.List;

import edu.tecmm.bytebuilders.foodservice.R;
import edu.tecmm.bytebuilders.foodservice.Usuario;

public class adapterUsuariosLista extends ArrayAdapter<User> {

    private List<Usuario> users;

    public adapterUsuariosLista(Context context, List<Usuario> users) {
        super(context, 0, users);
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_admin_page_inicio, parent, false);
        }

        Usuario user = users.get(position);

        TextView nombreTextView = convertView.findViewById(R.id.txtNombre);
        nombreTextView.setText(user.getUserName());

        TextView usuarioTextView = convertView.findViewById(R.id.txtUsuario);
        usuarioTextView.setText(user.getUserNamer());

        TextView rolTextView = convertView.findViewById(R.id.rol);
        rolTextView.setText(user.getUserPassword());

        return convertView;
    }
}
