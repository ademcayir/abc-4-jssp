import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Component;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;
import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class test {
	static beeColony bee = new beeColony();

	public void init() {
		//Container c = getContentPane();
		//formyap(c);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		formyap(frame);
		frame.setTitle("Ýþ Sýralama için Yapay Arý Kolonisi (Artificial Bee Colony)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800, 600);
	}
	
	static JButton baslat;
	static JComboBox combo;
	static JComboBox combo2;
	static JComboBox combo3;
	static JComboBox combo4;
	static boolean isrunning;
	static JTextArea textarea;
	static JProgressBar progress;
	static int bilinen_en_iyi;
	static int ais;
	static int grasp;
	static void addLog(String s){
		if (textarea != null ){
			textarea.append(s+"\r\n");
		}
	}
	static void formyap(Container c ){
		
		final JPanel frame = new JPanel();
		c.setLayout(new BorderLayout());
		c.add(frame,BorderLayout.CENTER);
		
		
		frame.setLayout(new GridBagLayout());
		
		
		int satir=0;
		
		// colony size
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		frame.add(new JLabel("Colony Size") ,g);
		
		g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		JButton b = new JButton("?");
		frame.add(b,g);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "The number of colony size (employed bees+onlooker bees)");
			}
		});
		
		g = new GridBagConstraints();
		g.gridx = 2;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(40);
		v.add(80);
		v.add(160);
		combo = new JComboBox(v);
		frame.add(combo,g);
		// end of colony size
		satir++;
		
		// limit
		
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		frame.add(new JLabel("Limit") ,g);
		
		g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		b = new JButton("?");
		frame.add(b,g);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "A food source which could not be improved through \"limit\" trials is abandoned by its employed bee");
			}
		});
		
		g = new GridBagConstraints();
		g.gridx = 2;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		v = new Vector<Integer>();
		v.add(50);
		v.add(100);
		v.add(200);
		v.add(400);
		combo2 = new JComboBox(v);
		frame.add(combo2,g);
		
		// end of limit
		satir++;
		// max cycle
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		frame.add(new JLabel("Max Cycle") ,g);
		
		g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		b = new JButton("?");
		frame.add(b,g);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "The number of cycles for foraging {a stopping criteria}");
			}
		});
		
		g = new GridBagConstraints();
		g.gridx = 2;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		v = new Vector<Integer>();
		v.add(1000);
		v.add(2500);
		v.add(5000);
		v.add(10000);
		v.add(20000);
		v.add(50000);
		v.add(100000);
		combo3 = new JComboBox(v);
		frame.add(combo3,g);
		// end of max cycle
		satir++;
		// max cycle
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		frame.add(new JLabel("OR Problem") ,g);
		
		g = new GridBagConstraints();
		g.gridx = 1;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		b = new JButton("?");
		frame.add(b,g);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "OR Library problems");
			}
		});
		
		g = new GridBagConstraints();
		g.gridx = 2;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		combo4 = new JComboBox(problems);
		frame.add(combo4,g);
		// end of max cycle
		
		satir++;
		
		
		// max cycle
		
		
		satir++;
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.fill = GridBagConstraints.BOTH;
		g.gridwidth = 3;
		baslat = new JButton("Start");
		frame.add(baslat,g);
		baslat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (baslat.getText().equals("Start")) {
					
					isrunning = true;
					baslat.setText("Stop");
					combo.setEnabled(false);
					combo2.setEnabled(false);
					combo3.setEnabled(false);
					combo4.setEnabled(false);
					
					int index = combo4.getSelectedIndex();
					bee.problem_to_solve = new Problem();
					InputStream in = "".getClass().getResourceAsStream("/problems/instance_"+problems[index]+".txt");
					try {
						bee.problem_to_solve.parse(in);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					try {
						in.close();
					} catch (Exception ex) {
					}
					bee.D = bee.problem_to_solve.getBoyutSayisi();
					
					bee.NP = ((Integer)combo.getSelectedItem()).intValue();
					bee.limit = ((Integer)combo2.getSelectedItem()).intValue();
					bee.maxCycle = ((Integer)combo3.getSelectedItem()).intValue();
					
					bee.masterInit();
					textarea.setText("");
					textarea.append("Problem: "+bee.problem_to_solve.name+"\r\n");
					progress.setValue(0);
					for (int i=0;i<values.length;i++) {
						if (values[i][0].equals("instance_"+bee.problem_to_solve.name+".txt")) {
							textarea.append("Bilinen En Ýyi Zaman: "+values[i][1]+"\r\n");
							bilinen_en_iyi = Integer.parseInt(values[i][1]);
							ais = 0;
							grasp = 0;
							if (values[i].length > 2) {
								ais = Integer.parseInt(values[i][2]);
								grasp = Integer.parseInt(values[i][3]);
								textarea.append("AIS En Ýyi Zaman: "+values[i][2]+"\r\n");
								textarea.append("GRASP En Ýyi Zaman: "+values[i][3]+"\r\n");
							}
						}
					}
					
					Thread t = new Thread(){
						public void run() {
							startToSolve();
						};
					};
					t.start();
					
				} else {
					combo.setEnabled(true);
					combo2.setEnabled(true);
					combo3.setEnabled(true);
					combo4.setEnabled(true);
					isrunning = false;
					baslat.setText("Start");
				}
			}
		});
		// end of max cycle
		
		
		satir++;
		
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.gridwidth = 3;
		progress = new JProgressBar();
		frame.add(progress,g);
		
		
		
		satir++;
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = satir;
		g.gridwidth = 3;
		g.weighty = 1;
		g.fill = GridBagConstraints.BOTH;
		textarea = new JTextArea();
		textarea.setEditable(false);
		textarea.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		frame.add(new JScrollPane(textarea),g);
		
		
		
		
		
		g = new GridBagConstraints();
		g.gridx = 3;
		g.gridy = 0;
		g.gridheight = satir+1;
		g.weightx= 1;
		g.fill = GridBagConstraints.BOTH;
		bee.drawing = new ScheduleComponent();
		frame.add(bee.drawing,g);
		
		
		frame.setSize(800,600);
				
		frame.setVisible(true);
	}
	
	
	static void startToSolve(){
		int iter = 0;
		int run = 0;
		int j = 0;
		double mean = 0;
		// srand(time(NULL));
		for (run = 0; run < bee.runtime && isrunning; run++) {
			bee.initial();
			bee.MemorizeBestSource();
			for (iter = 0; iter < bee.maxCycle && isrunning; iter++) {
				bee.SendEmployedBees();
				bee.CalculateProbabilities();
				bee.SendOnlookerBees();
				bee.MemorizeBestSource();
				bee.SendScoutBees();
				double yuzde = ((double)((run*bee.maxCycle) + iter) / (bee.runtime * bee.maxCycle))*100;
				progress.setValue((int)yuzde);
			}
			for (j = 0; j < bee.D; j++) {
				// System.out.println("GlobalParam[%d]: %f\n",j+1,GlobalParams[j]);
//				System.out.println("GlobalParam[" + (j + 1) + "]:"
//						+ bee.GlobalParams[j]);
			}
			// System.out.println("%d. run: %e \n",run+1,GlobalMin);
			System.out.println((run + 1) + ".run:" + bee.GlobalMin);
			bee.GlobalMins[run] = bee.GlobalMin;
			mean = mean + bee.GlobalMin;
		}
		progress.setValue(100);
		mean = mean / bee.runtime;
		double min = bee.GlobalMins[0];
		for (int i = 0; i < bee.GlobalMins.length; i++) {
			if (bee.GlobalMins[i] < min) {
				min = bee.GlobalMins[i];
			}
		}
		addLog("");
		String hata = ""+(100 * ((bee.GlobalMin - bilinen_en_iyi) / bilinen_en_iyi));
		hata = hata.substring(0,hata.indexOf(".")+2);
		addLog("YAK HATA: % " +  hata);
		
		if (ais != 0) {
			hata = ""+(100 * ((ais - bilinen_en_iyi) / (double)bilinen_en_iyi));
			hata = hata.substring(0,hata.indexOf(".")+2);
			addLog("AIS HATA: % " +  hata);
		} else {
			addLog("AIS HATA: VERÝ YOK");
		}
		if (grasp != 0) {
			hata = ""+(100 * ((grasp - bilinen_en_iyi) / (double)bilinen_en_iyi));
			hata = hata.substring(0,hata.indexOf(".")+2);
			addLog("GRASP HATA: % " +  hata);
		} else {
			addLog("GRASP HATA: VERÝ YOK");
		}
		
		
		// System.out.println("Means of %d runs: %e\n",runtime,mean);
		System.out.println("Means  of " + bee.runtime + "runs: " + mean+", min="+min);
		
		combo.setEnabled(true);
		combo2.setEnabled(true);
		combo3.setEnabled(true);
		combo4.setEnabled(true);
		isrunning = false;
		baslat.setText("Start");
	}
	static String problems[] = {
		"abz5",
		"abz7",
		"abz8",
		"abz9",
		"ft06",
		"ft10",
		"ft20",
		"la01",
		"la02",
		"la03",
		"la04",
		"la05",
		"la06",
		"la07",
		"la08",
		"la09",
		"la10",
		"la11",
		"la12",
		"la13",
		"la14",
		"la15",
		"la16",
		"la17",
		"la18",
		"la19",
		"la20",
		"la21",
		"la22",
		"la23",
		"la24",
		"la25",
		"la26",
		"la27",
		"la28",
		"la29",
		"la30",
		"la31",
		"la32",
		"la33",
		"la34",
		"la35",
		"la36",
		"la37",
		"la38",
		"la39",
		"la40",
		"orb01",
		"orb02",
		"orb03",
		"orb04",
		"orb05",
		"orb06",
		"orb07",
		"orb08",
		"orb09",
		"orb10",
		"ornek",
		"swv01",
		"swv02",
		"swv03",
		"swv04",
		"swv05",
		"swv06",
		"swv07",
		"swv08",
		"swv09",
		"swv10",
		"swv11",
		"swv12",
		"swv13",
		"swv14",
		"swv15",
		"swv16",
		"swv17",
		"swv18",
		"swv19",
		"swv20",
		"yn1",
		"yn2",
		"yn3",
		"yn4"
	};
	
	public static final String values[][] = {
		{ "instance_ornek.txt","13"},
		{ "instance_abz5.txt","1234","1238","1238"},
		{ "instance_abz7.txt","667","707","723"},
		{ "instance_abz8.txt","670","743","749"},
		{ "instance_abz9.txt","691","759","758"},
		{ "instance_ft06.txt","55",},
		{ "instance_ft10.txt","930","941","938"},
		{ "instance_ft20.txt","1165"},
		{ "instance_la01.txt","666","666","666"},
		{ "instance_la02.txt","655","655","655"},
		{ "instance_la03.txt","597","597","604"},
		{ "instance_la04.txt","590","590","590"},
		{ "instance_la05.txt","593","593","593"},
		{ "instance_la06.txt","926","926","926"},
		{ "instance_la07.txt","890","890","890"},
		{ "instance_la08.txt","863","863","863"},
		{ "instance_la09.txt","951","951","951"},
		{ "instance_la10.txt","958","958","958"},
		{ "instance_la11.txt","1222"},
		{ "instance_la12.txt","1039"},
		{ "instance_la13.txt","1150"},
		{ "instance_la14.txt","1292"},
		{ "instance_la15.txt","1207"},
		{ "instance_la16.txt","945","945","946"},
		{ "instance_la17.txt","784","785","784"},
		{ "instance_la18.txt","848","848","848"},
		{ "instance_la19.txt","842","848","842"},
		{ "instance_la20.txt","902","907","907"},
		{ "instance_la21.txt","1046"},
		{ "instance_la22.txt","927"},
		{ "instance_la23.txt","1032"},
		{ "instance_la24.txt","935"},
		{ "instance_la25.txt","902","1022","1028"},
		{ "instance_la26.txt","1218"},
		{ "instance_la27.txt","1235"},
		{ "instance_la28.txt","1216","1277","1293"},
		{ "instance_la29.txt","1195","1248","1293"},
		{ "instance_la30.txt","1355"},
		{ "instance_la31.txt","1784"},
		{ "instance_la32.txt","1850"},
		{ "instance_la33.txt","1719"},
		{ "instance_la34.txt","1721"},
		{ "instance_la35.txt","1888","1903","1888"},
		{ "instance_la36.txt","1268","1323","1334"},
		{ "instance_la37.txt","1397"},
		{ "instance_la38.txt","1217","1274","1267"},
		{ "instance_la39.txt","1233","1270","1290"},
		{ "instance_la40.txt","1222","1258","1259"},
		{ "instance_orb01.txt",""},
		{ "instance_orb02.txt","888","894","889"},
		{ "instance_orb03.txt","1005","1042","1021"},
		{ "instance_orb04.txt","1005","1028","1031"},
		{ "instance_orb05.txt",""},
		{ "instance_orb06.txt",""},
		{ "instance_orb07.txt",""},
		{ "instance_orb08.txt",""},
		{ "instance_orb09.txt",""},
		{ "instance_orb10.txt",""},
		{ "instance_swv01.txt","1418"},
		{ "instance_swv02.txt","1475"},
		{ "instance_swv03.txt","1398"},
		{ "instance_swv04.txt","1483"},
		{ "instance_swv05.txt","1434"},
		{ "instance_swv06.txt","1696"},
		{ "instance_swv07.txt","1620"},
		{ "instance_swv08.txt","1763"},
		{ "instance_swv09.txt","1663"},
		{ "instance_swv10.txt","1767"},
		{ "instance_swv11.txt","3005"},
		{ "instance_swv12.txt","3038"},
		{ "instance_swv13.txt","3146"},
		{ "instance_swv14.txt","2968"},
		{ "instance_swv15.txt","2940"},
		{ "instance_swv16.txt","2924"},
		{ "instance_swv17.txt","2794"},
		{ "instance_swv18.txt","2852"},
		{ "instance_swv19.txt","2843"},
		{ "instance_swv20.txt","2823"},
		{ "instance_yn1.txt","827"},
		{ "instance_yn2.txt","862"},
		{ "instance_yn3.txt","828"},
		{ "instance_yn4.txt","919"},
	};

}

class ScheduleComponent extends Container {
	
	private AltIsFrame alt_isler[];
	private double x_carpan;
	private double y_carpan;
	private int yayilma_zamani;
	private int makine_sayisi;
	private int draw_route=2;
	private Point draw_points[]; 
	public ScheduleComponent() {
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 1;
		g.weighty = 5;
		g.fill = GridBagConstraints.BOTH;
		add(table,g);
		
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.fill = GridBagConstraints.BOTH;
		add(info,g);
	}
	private static Color colors[]={
			Color.black,	
			Color.red,	
			Color.yellow,	
			Color.blue,	
			Color.pink,	
			Color.CYAN,	
			Color.green,
		};
	private Component info = new Component(){
		int current_x=-1,current_y=-1;
		{
			
			addMouseMotionListener(new MouseMotionListener(){
				public void mouseMoved(MouseEvent e) {
					current_x = e.getX();
					current_y = e.getY();
					ScheduleComponent.this.repaint();
				};
				public void mouseDragged(MouseEvent e) {
					current_x = e.getX();
					current_y = e.getY();
					ScheduleComponent.this.repaint();
				}
			});
			addMouseListener(new MouseAdapter(){
				public void mouseExited(MouseEvent e) {
					current_x = -1;
					current_y = -1;
					ScheduleComponent.this.repaint();
				}
			});
			
		}
		public void paint(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			if (alt_isler == null){
				return;
			}
			Graphics2D g2 = (Graphics2D)g;
			Font f = g.getFont();
			int is_sayisi = alt_isler.length/makine_sayisi;
			int satir = ((is_sayisi-1)/10)+1;
			String txt = (is_sayisi+1)+". Ýþ";
			Rectangle2D r2 = f.getStringBounds(txt,0 , txt.length(), g2.getFontRenderContext());
			int t_w = (int)r2.getWidth()+10;
			int cell_w = getWidth()/10 - t_w;
			int cell_h = getHeight()/(satir) - 4;
			int cur_x = 2;
			int cur_y = 2;
			g.setColor(Color.black);
			g.drawLine(0, 1, getWidth(), 1);
			draw_route = -1;
			for (int i = 0; i < satir; i++) {
				for (int j = 0; j < 10; j++) {
					int index = i*10+j;
					if (index >= is_sayisi){
						break;
					}
					AltIsFrame a = new AltIsFrame();
					a.is = index;
					int c_h = cell_h;
					if (c_h > (r2.getHeight()*5)/3){
						c_h = (int)(r2.getHeight()*5)/3;
					}
					a.draw(g, cur_x, cur_y, cell_w, c_h);
					if (current_x > cur_x && current_x < cur_x+cell_w && 
							current_y > cur_y && current_y < cur_y + c_h
					){
						draw_route = index;
					}
					g.setColor(Color.black);
					g.setClip(0, 0, getWidth(), getHeight());
					g.drawString((index+1)+". Ýþ", cur_x+cell_w+2, cur_y+(int)r2.getHeight());
					cur_x += t_w+cell_w;
				}
				cur_y += cell_h;
				cur_x = 2;
			}
			
			if(draw_route != -1){
				
				int yayilma_zamani = -1;
				int baslama_zamani = -1;
				int total = 0;
				for (int i = 0; i < alt_isler.length; i++) {
					if (alt_isler[i].is == draw_route){
						if (yayilma_zamani == -1){
							yayilma_zamani = alt_isler[i].baslangic+alt_isler[i].sure;
						}
						if (baslama_zamani == -1){
							baslama_zamani = alt_isler[i].baslangic;
						}
						
						if (alt_isler[i].baslangic < baslama_zamani){
							baslama_zamani = alt_isler[i].baslangic; 
						}
						if (alt_isler[i].baslangic + alt_isler[i].sure > yayilma_zamani){
							yayilma_zamani = alt_isler[i].baslangic + alt_isler[i].sure;	
						}
						total += alt_isler[i].sure;
					}
				}
				int h = (int)r2.getHeight()*4 + 10;
				int row_h = (int)r2.getHeight();
				int stary_y = current_y;
				String row1 = "Yayýlma Zamaný: "+yayilma_zamani;
				String row2 = "Baþlama Zamaný: "+baslama_zamani;
				String row3 = "Gecikme: "+(yayilma_zamani-baslama_zamani-total);
				
				int w = (int)f.getStringBounds(row2, 0,row2.length(),g2.getFontRenderContext()).getWidth() + 30;
				int start_x = current_x+10;
				if (stary_y + h > getHeight()){
					stary_y -= h;
				}
				if (start_x + w > getWidth()){
					start_x -= w + 20;
				}
				if (stary_y < 0){
					stary_y = 0;
				}
				g.setColor(Color.white);
				g.fillRect(start_x, stary_y, w, h);
				g.setColor(Color.black);
				g.drawRect(start_x, stary_y, w, h);
				g.drawString((draw_route+1)+". Ýþ ", start_x+3, stary_y+3+row_h);
				g.drawString(row1, start_x+3, stary_y+3+row_h*2);
				g.drawString(row2, start_x+3, stary_y+3+row_h*3);
				g.drawString(row3, start_x+3, stary_y+3+row_h*4);
				
				
			}
		};
	};
	private Component table = new Component(){
		private boolean rows[];
		private Polygon tmp = new Polygon(new int[4],new int[4],4);
		public void paint(Graphics g) {
			int w = getWidth();
			int h = getHeight();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, w, h);
			if (yayilma_zamani == 0){
				return;
			}
			Font font = g.getFont();
			Graphics2D g2 = (Graphics2D)g;
			String txt = (makine_sayisi+1)+". makine";
			Rectangle2D r = font.getStringBounds(txt, 0, txt.length(), g2.getFontRenderContext());
			
			if (rows == null || rows.length != makine_sayisi){
				rows = new boolean[makine_sayisi];
			} else {
				for (int i = 0; i < rows.length; i++) {
					rows[i] = false;
				}
			}
			for (int i = 0; i < makine_sayisi; i++) {
				g.setColor(Color.black);
				g.drawString((i+1)+". makine", 5, (h/makine_sayisi)*(i)+(h/makine_sayisi)/2 );
			}
			int translate = (int)r.getWidth()+10;
			w -= translate;
			
			if (yayilma_zamani != 0){
				x_carpan = w/((double)yayilma_zamani);
				y_carpan = h / ((double)makine_sayisi);
				for (int i = 0; alt_isler != null && i < alt_isler.length; i++) {
					if (alt_isler[i] != null){
						g.translate(translate, 0);
						alt_isler[i].draw(g);
						g.translate(-translate, 0);
						g.setColor(Color.black);
						g.setClip(0,0,getWidth(),getHeight());
						int y = (int)(alt_isler[i].makine * y_carpan);
						g.drawLine(0, y, getWidth(), y);
					}
				}
				if (draw_route != -1){
					for (int j = 0; j < draw_points.length-1; j++) {
						for (int i = 0; i < draw_points.length-1-j; i++) {
							if (draw_points[i].x > draw_points[i+1].x){
								Point tmp = draw_points[i];
								draw_points[i] = draw_points[i+1];
								draw_points[i+1]=tmp;
							}
						}
					}
					
					for (int j = 0; j < draw_points.length-1; j++) {
						int x_add;
						if (draw_points[j].y > draw_points[j+1].y){
							x_add = -1;
						} else {
							x_add = +1;
						}
						
						
						tmp.xpoints[0] = draw_points[j].x+translate-x_add;
						tmp.ypoints[0] = draw_points[j].y+1;
						
						tmp.xpoints[1] = draw_points[j].x+translate+x_add;
						tmp.ypoints[1] = draw_points[j].y-1;
						
						tmp.xpoints[2] = draw_points[j+1].x+translate+x_add;
						tmp.ypoints[2] = draw_points[j+1].y-1;
						
						tmp.xpoints[3] = draw_points[j+1].x+translate-x_add;
						tmp.ypoints[3] = draw_points[j+1].y+1;
						g.setColor(Color.black);
						g.fillPolygon(tmp);
						g.setColor(Color.white);
						g.drawLine(draw_points[j].x+translate, draw_points[j].y, draw_points[j+1].x+translate, draw_points[j+1].y);
						
					}
				}
			}
			
		}
	};
	
	
	public void update(Problem problem){
		alt_isler = new AltIsFrame[problem.makine_sayisi * problem.is_sayisi];
		int counter = 0;
		yayilma_zamani = problem.yayilma_zamani;
		makine_sayisi = problem.makine_sayisi;
		draw_points = new Point[makine_sayisi];
		for (int i = 0; i < problem.isler.length; i++) {
			Is is = problem.isler[i];
			AltIs tmp = is.baslangic;
			while (tmp.is_icin_sonrasi != null){
				tmp = tmp.is_icin_sonrasi;
				alt_isler[counter] = new AltIsFrame();
				alt_isler[counter].baslangic = tmp.baslangic_zamani;
				alt_isler[counter].sure = tmp.sure;
				alt_isler[counter].makine = tmp.makine;
				alt_isler[counter].is = tmp.parent.is_no;
				counter++;
			}
		}
		for (int i = 0; i < draw_points.length; i++) {
			draw_points[i] = new Point(0,0);
		}
		table.invalidate();
		table.repaint();
		invalidate();
		repaint();
	}
	class AltIsFrame {
		int is;
		int baslangic;
		int sure;
		int makine;
		private Polygon p1 = new Polygon(new int[]{0,0,0,0},new int[]{0,0,0,0},4);
		private Polygon p2 = new Polygon(new int[]{0,0,0,0},new int[]{0,0,0,0},4);
		void draw(Graphics g){
			int x = (int)(baslangic * x_carpan);
			int y = (int)(makine * y_carpan);
			int w = (int)(sure * x_carpan);
			int h = (int)y_carpan;
			draw(g,x,y,w,h);
			if (draw_route == is){
				draw_points[makine].setLocation(x+w/2,y+h/2);
			}
		}
		
		void draw(Graphics g,int x,int y,int w,int h){
			
			g.setClip(x, y, w, h);	
			if (is < colors.length){
				g.setColor(colors[is]);
				g.fillRect(x, y, w, h);
			} else {
				Color c1 = colors[is%colors.length];
				Color c2 = colors[(is-1)%colors.length];
				int step_size = h/6;
				if (step_size <= 0){
					step_size = 1;
				}
				int target = w;
				if (h > w){
					target = h;
				}
				int cur = 0;
				for (int i = 0; cur < target ; i++) {
					if (i%2==0){
						g.setColor(c1);
					} else {
						g.setColor(c2);
					}
					if (is % 2 == 0){
						p1.xpoints[0] = x + cur;
						p1.ypoints[0] = y;
						
						p1.xpoints[1] = x + cur + step_size;
						p1.ypoints[1] = y;
						
						p1.xpoints[2] = x;
						p1.ypoints[2] = y+cur+step_size;
						
						p1.xpoints[3] = x;
						p1.ypoints[3] = y+cur;
						
						p2.xpoints[0] = x+target;
						p2.ypoints[0] = y+cur;
						
						p2.xpoints[1] = x+target;
						p2.ypoints[1] = y+cur+step_size;
						
						p2.xpoints[2] = x+cur+step_size;
						p2.ypoints[2] = y+target;
						
						p2.xpoints[3] = x+cur;
						p2.ypoints[3] = y+target;
						
						
					} else {
						
						p1.xpoints[0] = x + cur;
						p1.ypoints[0] = y;
						
						p1.xpoints[1] = x + cur + step_size;
						p1.ypoints[1] = y;
						
						p1.xpoints[2] = x+target;
						p1.ypoints[2] = y+target - cur - step_size;
						
						p1.xpoints[3] = x+target;
						p1.ypoints[3] = y+target - cur;
						
						
						p2.xpoints[0] = x;
						p2.ypoints[0] = y+cur;
						
						p2.xpoints[1] = x;
						p2.ypoints[1] = y+cur+step_size;
						
						p2.xpoints[2] = x + target - cur - step_size;
						p2.ypoints[2] = y+target;
						
						p2.xpoints[3] = x + target - cur;
						p2.ypoints[3] = y+target;
						
					}
					g.fillPolygon(p1);
					g.fillPolygon(p2);
					cur += step_size;
				}
			}
		}
	}
	
	
}
