package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {

	//現在時刻表示
	private TextField textClock = new TextField(60);
	//警備センター出力
	private TextArea textScreen = new TextArea(10,60);
	//各種ボタン
	private Button buttonUse = new Button("金庫使用");
	private Button buttonAlarm = new Button("非常ベル");
	private Button buttonPhone = new Button("通常通話");
	private Button buttonExit = new Button("終了");

	private State state = DayState.getInstance();

	public SafeFrame(String title){
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());

		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);

		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);

		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);

		add(panel, BorderLayout.SOUTH);

		//表示
		pack();
		show();

		//リスナの設定
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	//ボタンが押されたときのイベント処理
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(e.toString());
		if(e.getSource() == buttonUse){
			state.doUse(this);
		}else if(e.getSource() == buttonAlarm){
			state.doAlarm(this);
		}else if(e.getSource() == buttonPhone){
			state.doPhone(this);
		}else if(e.getSource() == buttonExit){
			System.exit(0);
		}else{
			System.out.println("?");
		}
	}

	//時刻の設定
	@Override
	public void setClock(int hour) {
		String clockString = "現在時刻は";
		if(hour < 10){
			clockString += "0" + hour + ":00";
		}else{
			clockString += hour + ":00";
		}
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}

	//状態変化
	@Override
	public void changeState(State state) {
		System.out.println(this.state + "から" + state + "へ状態が変化しました");
		this.state = state;
	}

	//警備センター呼び出し
	@Override
	public void callSecurityCenter(String msg){
		textScreen.append("call! " + msg + "\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}

}
