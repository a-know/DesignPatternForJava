package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueCheckBox checkGuest;
	private ColleagueCheckBox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	public LoginFrame(String title){
		super(title);
		setBackground(Color.LIGHT_GRAY);
		//レイアウトマネージャを使って4x2のグリッドを生成
		setLayout(new GridLayout(4,2));
		//Colleague群の生成
		createColleagues();
		//Colleague群の配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		//初期設定
		colleagueChanged();
		//表示
		pack();
		show();
	}
	@Override
	public void createColleagues() {
		//生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckBox("Guest", g, true);
		checkLogin = new ColleagueCheckBox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");

		//Mediatorのセット
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);

		//Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	//Colleagueからの通知で各Colleagueの有効/無効を判定する
	@Override
	public void colleagueChanged() {
		if(checkGuest.getState()){//Guestモード
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}else{//Loginモード
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	//textUserまたはtextPassの変更があったときに
	//各Coleagueの有効/無効を判定する
	private void userpassChanged(){
		if(textUser.getText().length() > 0){
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length() > 0){
				buttonOk.setColleagueEnabled(true);
			}else{
				buttonOk.setColleagueEnabled(false);
			}
		}else{
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}

}
