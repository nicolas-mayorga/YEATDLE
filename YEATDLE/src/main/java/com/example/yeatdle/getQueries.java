package com.example.yeatdle;


import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

import java.util.Objects;

public class getQueries {

    public static ArrayList<String> getSongs() {
        ArrayList<String> tracks = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String trackNamesQuery = "select trackName from trackinfo";
            Statement statement = connection.createStatement();
            ResultSet allTracks = statement.executeQuery(trackNamesQuery);
            while (allTracks.next()) {
                tracks.add(allTracks.getString("trackName"));
            }
        } catch (SQLException e) {
            System.out.println("Error. Not connected.");
        }
        return tracks;
    }

    public static String getSongName(String input){
        String songName = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select trackName from trackinfo where trackName = \"" + input + "\"";
            Statement st = connection.createStatement();
            ResultSet songQuery = st.executeQuery(query);
            while (songQuery.next()) {
                songName = songQuery.getString("trackName");
            }
            } catch (SQLException e){
            System.out.println("getsongname error");
        } return songName;
    }
    public static int getTrackNumber(String input) {
        int trackNumber = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select trackNumber from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                trackNumber = songQuery.getInt("trackNumber");
            }
        } catch (SQLException error) {
            System.out.println("gettracknumber error");
        }
        return trackNumber;
    }

    public static int getTrackLength(String input) {
        int trackLength = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select trackLength from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                trackLength = songQuery.getInt("trackLength");
            }
        } catch (SQLException error) {
            System.out.println("gettracklength error");
        }
        return trackLength;
    }
    public static String getFeature(String input) {
        String trackFeature = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String trackAlbumQuery = "select features from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet trackAlbums = statement.executeQuery(trackAlbumQuery);
            while (trackAlbums.next()) {
                trackFeature = trackAlbums.getString("features");
            }
        } catch (SQLException error) {
            System.out.println("getfeatures error");
        }
        return trackFeature;
    }
    public static String getAlbum(String input) {
        String album = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select album from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                album = songQuery.getString("album");
            }
        } catch (SQLException error) {
            System.out.println("getalbum error");
        }
        return album;
    }

    public static int getAlbumNum(String input) {
        int albumNum = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select albumNum from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                albumNum = songQuery.getInt("albumNum");
            }
        } catch (SQLException error) {
            System.out.println("getalbum error");
        }
        return albumNum;
    }


    public static String getTrackLengthText(String input) {
        String mins = "0";
        int sec = 0;
        int length = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select trackLength from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                length = songQuery.getInt("trackLength");
            }
        } catch (SQLException error) {
            System.out.println("gettracklength error");

        } mins = String.valueOf(length / 60);
        sec = (length % 60);
        return mins + ":" + String.format("%02d", sec);
    }

    public static String getTrackNumberText(String input) {
        String trackNumber = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeatdb", "root", "pass");
            String query = "select trackNumber from trackinfo where trackName = \"" + input + "\"";
            Statement statement = connection.createStatement();
            ResultSet songQuery = statement.executeQuery(query);
            while (songQuery.next()) {
                trackNumber = songQuery.getString("trackNumber");
            }
        } catch (SQLException error) {
            System.out.println("gettracknumber error");
        }
        return trackNumber;
    }

    public static String getTrackNumberArrow(String mysteryInput, String input){
        String arrow;
        if (getTrackNumber(mysteryInput) > getTrackNumber(input)) {
            arrow = "↑↑";
            if (getTrackNumber(mysteryInput) >= getTrackNumber(input) - 2 && getTrackNumber(mysteryInput) <= getTrackNumber(input) + 2) {
                arrow = "↑";
            }
        } else if (getTrackNumber(mysteryInput) < getTrackNumber(input)) {
            arrow = "↓↓";
            if (getTrackNumber(mysteryInput) <= getTrackNumber(input) + 2 && getTrackNumber(mysteryInput) >= getTrackNumber(input) - 2) {
                arrow = "↓";
            }
        }
        else {
            arrow = "=";

        } return arrow;
    }

    public static String getTrackLengthArrow(String mysteryInput, String input){
        String arrow;
        if (getTrackLength(mysteryInput) > getTrackLength(input)) {
            arrow = "↑↑";
            if (getTrackLength(mysteryInput) >= getTrackLength(input) - 30 && getTrackLength(mysteryInput) <= getTrackLength(input) + 30) {
                arrow = "↑";
        }
        } else if (getTrackLength(mysteryInput) < getTrackLength(input)) {
            arrow = "↓↓";
            if (getTrackLength(mysteryInput) <= getTrackLength(input) + 30 && getTrackLength(mysteryInput) >= getTrackLength(input) - 30) {
                arrow = "↓";
        }
        }
        else {
            arrow = "=";

        } return arrow;
    }
    public static String checkAlbumEquals(String mysteryInput, String input) {
        String check;
        if (getAlbumNum(mysteryInput) == getAlbumNum(input)) {
            check = "=";
        } else {
            check = "";
        }
        return check;
    }
    public static String checkFeatureEquals (String mysteryInput, String input) {
        String check;
        if ((Objects.equals(getFeature(mysteryInput), getFeature(input)))) {
            check = "=";
        } else {
            check = "";
        }
        return check;
    }
}