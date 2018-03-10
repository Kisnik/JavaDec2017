import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class General extends JFrame {
    private JPanel panelMain;
    private JTextField browsePath;
    private JButton buttonGC;
    private JButton buttonO;
    private JButton buttonMF;
    private JButton buttonYA;
    private JButton browse;

    public General() throws IOException {
        super("Music from cache");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout(5, 5));
        panelMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new GridLayout(1, 2, 5, 5));
        panelMain.add(browsePanel, BorderLayout.NORTH);

        JTextField browsePath = new JTextField();
        browsePanel.add(browsePath);

        Path defaultPath = Paths.get("D:\\MusicCache");
        if (!Files.exists(defaultPath)) Files.createDirectory(defaultPath);// creating default target path

        JButton browse = new JButton("Select folder to copy cache");
        browse.setFocusable(false);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser pathget = new JFileChooser();
                pathget.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int res = pathget.showDialog(null, "Choose path");
                if (res == JFileChooser.APPROVE_OPTION) {
                    File path = pathget.getSelectedFile();
                    browsePath.setText(path.getAbsolutePath());
                }
            }
        });

        browsePanel.add(browse, BorderLayout.EAST);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4, 5, 5));
        panelMain.add(buttonsPanel, BorderLayout.CENTER);


        JButton buttonGC = new JButton("Google Chrome");
        buttonGC.setFocusable(false);
        buttonGC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!browsePath.equals(null)) {
                    Path toPath = Paths.get(browsePath.getText());
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Google", "Chrome", "User Data", "Default", "Media Cache")
                            .toAbsolutePath().toString()), toPath);
                } else {
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Google", "Chrome", "User Data", "Default", "Media Cache")
                            .toAbsolutePath().toString()), defaultPath);
                }
            }
        });

        JButton buttonO = new JButton("Opera");
        buttonO.setFocusable(false);
        buttonO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!browsePath.equals(null)) {
                    Path toPath = Paths.get(browsePath.getText());
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Opera Software", "Opera Stable", "Media Cache")
                            .toAbsolutePath().toString()), toPath);
                } else {
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Opera Software", "Opera Stable", "Media Cache")
                            .toAbsolutePath().toString()), defaultPath);
                }
            }
        });

        JButton buttonMF = new JButton("Mozilla Firefox");
        buttonMF.setFocusable(false);
        buttonMF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!browsePath.equals(null)) {
                    Path toPath = Paths.get(browsePath.getText());
                    ForMozilla.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "Local Settings", "Application Data", "Mozilla", "Firefox",
                            "Profiles", "zayl0w0i.default", "cache2", "entries").toAbsolutePath().toString()), toPath);
                } else {
                    ForMozilla.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "Local Settings", "Application Data", "Mozilla", "Firefox",
                            "Profiles", "zayl0w0i.default", "cache2", "entries").toAbsolutePath().toString()), defaultPath);
                }
            }
        });

        JButton buttonYA = new JButton("Yandex Browser");
        buttonYA.setFocusable(false);
        buttonYA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!browsePath.equals(null)) {
                    Path toPath = Paths.get(browsePath.getText());
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Yandex", "YandexBrowser", "User Data", "Default", "Media Cache")
                            .toAbsolutePath().toString()), toPath);
                } else {
                    ForChromium.getMusic(Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Yandex", "YandexBrowser", "User Data", "Default", "Media Cache")
                            .toAbsolutePath().toString()), defaultPath);
                }
            }
        });
        buttonsPanel.add(buttonGC);
        buttonsPanel.add(buttonO);
        buttonsPanel.add(buttonMF);
        buttonsPanel.add(buttonYA);

        getContentPane().add(panelMain);
        setPreferredSize(new Dimension(800, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                try {
                    new General();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
