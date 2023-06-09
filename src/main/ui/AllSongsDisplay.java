package ui;

import model.Library;
import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;

// creates pop-up window with all song names listed
public class AllSongsDisplay extends JFrame {

    private JPanel panel;
    private Library library;
    private Playlist allSongs;
    private String songs;

    // MODIFIES: this
    // EFFECTS: creates the pop-up window with names of all songs listed
    public AllSongsDisplay(Library playlists) {
        library = playlists;
        allSongs = library.findPlaylist("Song Library");
        createPanel();
        outputSongs(allSongs);

        this.setTitle("Songs in your Library");
        this.setSize(300, 600);
        this.add(panel);
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: outputs the names of songs from a playlist via JLabels
    public void outputSongs(Playlist playlist) {
        StringBuilder s = new StringBuilder();
        for (Song song : playlist.getSongList()) {
            s.append(song.getName()).append("<br>");
            songs = "<html>" + s + "</html>";
        }
        panel.add(new JLabel(songs));
    }

    // MODIFIES: this
    // EFFECTS: creates panel where the list of the songs will be displayed
    public void createPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(600, 300));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
}