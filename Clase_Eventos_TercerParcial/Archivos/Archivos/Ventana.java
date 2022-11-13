package Archivos;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Ventana extends JFrame {
    private String ruta="";
    private File arc=null;
    MenuF fondoMenu = new MenuF();
    
	private JPanel contentPane;
	private JTextField texRuta;
	private JTextField texExiste;
	private JEditorPane ediContenido2;
	private JTextField texTexto;
	private JTextField texTexto2;
	private JTextField texTexto3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ventana() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/Archivos/carpeta.png")));
		setTitle("Archivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 445, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConectar = new JButton("Ruta");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				texRuta.setText("");
				texExiste.setText("");
				 arc=new File("base.txt");
				ruta=arc.getAbsolutePath();
				texRuta.setText(ruta);			
				if (arc.exists()) { 
					texExiste.setText(arc.exists()+"");
				
				}else {
					 try {
						arc.createNewFile();
						texExiste.setText(arc.exists()+"");
						JOptionPane.showMessageDialog(null,"Se a creado el archivo");
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null,e.getMessage()+"Error al crear el archivo");
					}
				}
			}
		});
		
		JButton btnAgregar = new JButton(" Agregar ");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw;
				try {
					fw = new FileWriter(arc);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(ediContenido2.getText()+texTexto.getText());					
					bw.close();
					mostrar();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Salir.setBounds(335, 405, 89, 23);
		contentPane.add(Salir);
		
		btnAgregar.setBounds(335, 98, 89, 23);
		contentPane.add(btnAgregar);		
		
		JButton btnAgregar_2 = new JButton(" Agregar ");
		btnAgregar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw;
				try {
					fw = new FileWriter(arc);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(ediContenido2.getText()+texTexto3.getText());					
					bw.close();
					mostrar();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAgregar_2.setBounds(335, 173, 89, 23);
		contentPane.add(btnAgregar_2);
		
		JButton btnAgregar_1 = new JButton(" Agregar ");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw;
				try {
					fw = new FileWriter(arc);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(ediContenido2.getText()+texTexto2.getText());					
					bw.close();
					mostrar();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAgregar_1.setBounds(335, 132, 89, 23);
		contentPane.add(btnAgregar_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ingresa tu correo:");
		lblNewLabel_3_2.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_3_2.setBounds(10, 177, 180, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ingresa tu edad:");
		lblNewLabel_3_1.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_3_1.setBounds(10, 137, 180, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresa tu nombre:");
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_3.setBounds(10, 102, 180, 14);
		contentPane.add(lblNewLabel_3);
		btnConectar.setBounds(136, 405, 108, 23);
		contentPane.add(btnConectar);
		
		JLabel lblNewLabel = new JLabel("Ruta:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Existe");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(10, 51, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		texRuta = new JTextField();
		texRuta.setBounds(70, 12, 354, 20);
		contentPane.add(texRuta);
		texRuta.setColumns(10);
		
		texExiste = new JTextField();
		texExiste.setColumns(10);
		texExiste.setBounds(70, 48, 120, 20);
		contentPane.add(texExiste);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mostrar();					
			}
		});
		btnMostrar.setBounds(10, 405, 108, 23);
		contentPane.add(btnMostrar);
		ediContenido2 = new JEditorPane();
		ediContenido2.setForeground(SystemColor.activeCaptionText);
		ediContenido2.setBackground(SystemColor.window);
		ediContenido2.setBounds(10, 251, 411, 116);
		contentPane.add(ediContenido2);
		
		JPanel panel = new MenuF();
		panel.setBounds(0, 0, 545, 446);
		contentPane.add(panel);
		
		texTexto = new JTextField();
		texTexto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		texTexto.setBounds(136, 99, 180, 20);
		contentPane.add(texTexto);
		texTexto.setColumns(10);
		
		texTexto2 = new JTextField();
		texTexto2.setBorder(new LineBorder(SystemColor.desktop, 2));
		texTexto2.setColumns(10);
		texTexto2.setBounds(136, 134, 180, 20);
		contentPane.add(texTexto2);
		
		texTexto3 = new JTextField();
		texTexto3.setBorder(new LineBorder(SystemColor.desktop, 2));
		texTexto3.setColumns(10);
		texTexto3.setBounds(136, 174, 180, 20);
		contentPane.add(texTexto3);
	
	}
	public void mostrar () {
		try {
			ediContenido2.setText("");
			FileReader ent=new FileReader(ruta);
			BufferedReader miBuffer=new BufferedReader(ent);
			String linea="";
			while(linea!=null){
				linea=miBuffer.readLine();							
				if(linea==null) break;
				ediContenido2.setText(ediContenido2.getText()+ linea+"\n");
			}
            ent.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()+"El archivo no existe");					
		}
	
	}	class  MenuF extends JPanel{
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image imagen;
		  
		   public void paint(Graphics g) {
		    imagen= new ImageIcon(getClass().getResource("Dise2.png")).getImage();
		    g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
		    setOpaque(false);
		    super.paint(g);
		   }
	}
}
