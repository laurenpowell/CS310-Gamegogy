package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import org.json.*;

public class JSONWebservice {
    
    public static List<String[]> getStudent() {
        String idList = Connection.createConnection("studentlist");
        JSONArray ids = new JSONArray(idList);
        List<String[]> list = new ArrayList<>();
        
        for(Object id : ids) {
            String student = Connection.createConnection("student/" + id);
            JSONObject obj = new JSONObject(student);
            String[] array = {obj.getString("id"), obj.getString("first"),
                              obj.getString("last"), obj.getString("email")};
            list.add(array);
        }
        return list;
    }
    
    public static List<String[]> getCourse() {
        String idList = Connection.createConnection("courselist");
        JSONArray ids = new JSONArray(idList);
        List<String[]> list = new ArrayList<>();
        
        for(Object id : ids) {
            String course = Connection.createConnection("course/" + id);
            JSONObject obj = new JSONObject(course);
            String[] array = {obj.getString("id"), obj.getString("term"),
                              obj.getString("year"), "" + obj.getInt("size")};
            list.add(array);
        }
        return list;
    }
    
    public static List<List<String[]>> getGrades() {
        String idList = Connection.createConnection("courselist");
        JSONArray ids = new JSONArray(idList);
        List<List<String[]>> grades = new ArrayList<>();
        
        for(Object id : ids) {
            List<String[]> list = new ArrayList<>();
            String course = Connection.createConnection("course/" + id);
            JSONObject temp = new JSONObject(course);
            JSONObject obj = temp.getJSONObject("grades");
            
            JSONArray headerTemp = obj.getJSONArray("colHeaders");
            JSONArray idTemp = obj.getJSONArray("rowHeaders");
            JSONArray dataTemp = obj.getJSONArray("data");
            
            String[] header = new String[headerTemp.length()];
            int k = 0;
            for(Object col : headerTemp) {
                header[k++] = "" + col;
            }
            list.add(header);
            
            for(int i = 0; i < idTemp.length(); i++) {
                JSONArray subTemp = dataTemp.getJSONArray(i);
                String[] data = new String[subTemp.length()+1];
                data[0] = idTemp.getString(i);
                for(int j = 0; j < subTemp.length(); j++) {
                    data[j+1] = "" + subTemp.getDouble(j);
                }
                list.add(data);
            }
            grades.add(list);
        }
        return grades;
    }
    
}
/*
{
    "id":"99000","term":"Spring","year":"2013","size":11,
    "grades":{
            "colHeaders":["Total","Assignment 1","Assignment 2","Assignment 3","Assignment 4","Assignment 5","Assignment 6","Assignment 7","Assignment 8","Assignment 9","Exam 1"],
            "rowHeaders":["111318","111383","111190","111406","111115","111211","111208","111310","111335","111141","111262"],
            "data":[[925.0,65.0,58.0,52.0,60.0,66.0,66.0,59.0,57.0,58.0,384.0],
            [741.0,55.0,54.0,59.0,54.0,45.0,48.0,42.0,43.0,58.0,283.0],
            [511.0,40.0,35.0,24.0,29.0,50.0,33.0,43.0,35.0,40.0,182.0],
            [524.0,34.0,38.0,36.0,26.0,36.0,37.0,44.0,41.0,40.0,192.0],
            [561.0,41.0,36.0,36.0,25.0,42.0,29.0,34.0,35.0,20.0,263.0],
            [488.0,36.0,27.0,36.0,32.0,43.0,34.0,28.0,45.0,22.0,185.0],
            [614.0,41.0,31.0,40.0,43.0,48.0,38.0,40.0,42.0,43.0,248.0],
            [852.0,58.0,58.0,54.0,57.0,66.0,49.0,42.0,57.0,66.0,345.0],
            [558.0,36.0,29.0,33.0,35.0,46.0,45.0,48.0,45.0,49.0,192.0],
            [381.0,34.0,29.0,26.0,37.0,27.0,27.0,29.0,36.0,29.0,107.0],
            [675.0,46.0,50.0,51.0,49.0,44.0,47.0,43.0,49.0,43.0,253.0]]
        }
}
*/