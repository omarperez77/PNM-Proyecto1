package edu.tecmm.bytebuilders.foodservice;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter extends BaseExpandableListAdapter {
    //inicializar la variable
    ArrayList<String> listGroup;
    HashMap<String, ArrayList<String>> listChild;

    //crear el constructor
    public MainAdapter(ArrayList<String> listGroup, HashMap<String, ArrayList<String>> listChild) {
        this.listGroup = listGroup;
        this.listChild = listChild;
    }

    @Override
    public int getGroupCount() {
        //return tamaño grupo de listas
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //que devuelva el tamaño de la lista child
        return listChild.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //que devuelva  el item de group
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        boolean attachToRoot;
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_expandable_list_item_1
                        , parent, attachToRoot = false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        String sGroup = String.valueOf(getGroup(groupPosition));
        textView.setText(sGroup);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLUE);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        boolean attchToRoot;
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_selectable_list_item
                        , parent, attchToRoot = false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        String sChild = String.valueOf(getChild(groupPosition, childPosition));
        textView.setText(sChild);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Descripción", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
