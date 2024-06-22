import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    private JTextField usuarioField;
    private JTextField idField;
    private JTextField libroField;
    private JTextField autorField;
    private JTextField categoriaField;
    private JTextField fechaPrestamoField;
    private JTextField fechaDevolucionField;
    private ArrayList<String> registros;

    public Menu() {
        // gui
        setTitle("Préstamos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(127, 140, 141));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        addImage(panel, gbc);

        usuarioField = addField(panel, gbc, "Usuario:", 1);
        idField = addField(panel, gbc, "Número de Identificación:", 2);
        libroField = addField(panel, gbc, "Libro:", 3);
        autorField = addField(panel, gbc, "Autor:", 4);
        categoriaField = addField(panel, gbc, "Categoría:", 5);
        fechaPrestamoField = addField(panel, gbc, "Fecha del Préstamo (dd/mm/yyyy):", 6);
        fechaDevolucionField = addField(panel, gbc, "Fecha de Devolución (dd/mm/yyyy):", 7);

        JButton botonPrestamo = new JButton("Realizar Préstamo");
        botonPrestamo.setBackground(new Color(21, 67, 96));
        botonPrestamo.setForeground(Color.WHITE);
        botonPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPrestamoEjemplo();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(botonPrestamo, gbc);

        JButton botonMostrarRegistros = new JButton("Mostrar Registros");
        botonMostrarRegistros.setBackground(new Color(21, 67, 96));
        botonMostrarRegistros.setForeground(Color.WHITE);
        botonMostrarRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistros();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(botonMostrarRegistros, gbc);

        registros = new ArrayList<>();

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addImage(JPanel panel, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("imgs/IMAGEN.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, gbc);
        gbc.gridwidth = 1;
    }

    private JTextField addField(JPanel panel, GridBagConstraints gbc, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(26, 82, 118));
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(label, gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = y;
        panel.add(textField, gbc);

        return textField;
    }

    private void realizarPrestamoEjemplo() {
        String nombreUsuario = usuarioField.getText();
        String idUsuario = idField.getText();
        String nombreLibro = libroField.getText();
        String autorLibro = autorField.getText();
        String categoriaLibro = categoriaField.getText();
        String fechaPrestamo = fechaPrestamoField.getText();
        String fechaDevolucion = fechaDevolucionField.getText();

        String registro = String.format(
                "Usuario: %s\nNúmero de Identificación: %s\nLibro: %s\nAutor: %s\nCategoría: %s\nFecha del Préstamo: %s\nFecha de Devolución: %s\n",
                nombreUsuario, idUsuario, nombreLibro, autorLibro, categoriaLibro, fechaPrestamo, fechaDevolucion
        );

        registros.add(registro);
        JOptionPane.showMessageDialog(this, "Préstamo realizado");

        usuarioField.setText("");
        idField.setText("");
        libroField.setText("");
        autorField.setText("");
        categoriaField.setText("");
        fechaPrestamoField.setText("");
        fechaDevolucionField.setText("");
    }

    private void mostrarRegistros() {
        StringBuilder registrosTexto = new StringBuilder();
        for (String registro : registros) {
            registrosTexto.append(registro).append("\n").append("-".repeat(40)).append("\n");
        }
        JOptionPane.showMessageDialog(this, registrosTexto.toString(), "Registros de Préstamos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
}