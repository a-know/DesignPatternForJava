package command;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import command.command.Command;
import command.command.DrawCommand;
import command.command.MacroCommand;
import command.drawer.DrawCanvas;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener{

	//描画履歴
	private MacroCommand history = new MacroCommand();
	//描画領域
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	//消去ボタン
	private JButton clearButton = new JButton("clear");
	//保持されたコマンドの数（オリジナル）
	private Label commandsNumber = new Label("0");

	public Main(String title){
		super(title);

		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);

		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		buttonBox.add(commandsNumber);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		pack();
		show();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main("Command pattern sample");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		//no operation
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//no operation
	}

	@Override
	public void windowIconified(WindowEvent e) {
		//no operation
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		//no operation
	}

	@Override
	public void windowActivated(WindowEvent e) {
		//no operation
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		//no operation
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command c = new DrawCommand(canvas, e.getPoint());
		//描画と同時に履歴にも保持
		history.append(c);
		c.execute();
		commandsNumber.setText(Integer.toString(history.getCommandsNumber()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//no operation
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clearButton){
			history.clear();
			canvas.repaint();
			commandsNumber.setText(Integer.toString(history.getCommandsNumber()));
		}
	}
}
