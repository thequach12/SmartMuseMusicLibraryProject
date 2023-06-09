package ui;

import model.Library;
import model.Playlist;

import javax.swing.*;
import java.awt.*;

// creates a pop-up with all playlist names listed
public class AllPlaylistDisplay extends JFrame {

    private JPanel panel;
    private Library library;
    private String allPlaylists;

    // MODIFIES: this
    // EFFECTS: creates the pop-up window with the names of playlists listed
    public AllPlaylistDisplay(Library playlists) {
        library = playlists;
        createPanel();
        outputPlaylists();

        this.setTitle("Playlists in your Library");
        this.setSize(300, 600);
        this.add(panel);
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: outputs the names of playlists from the library via JLabels
    public void outputPlaylists() {
        StringBuilder pl = new StringBuilder();
        for (Playlist playlist : library.getPlaylists()) {
            pl.append(playlist.getName()).append("<br>");
            allPlaylists = "<html>" + pl + "</html>";
        }
        panel.add(new JLabel(allPlaylists));
    }

    // MODIFIES: this
    // EFFECTS: creates panel where the list of the playlists will be displayed
    public void createPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(600, 300));
    }
}
