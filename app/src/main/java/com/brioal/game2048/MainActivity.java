package com.brioal.game2048;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * TODO 代码整理 图标设置
 */
public class MainActivity extends Activity {
	private SharedPreferences preferences ;
	private SharedPreferences.Editor editor ;
	private int score = 0;
	private TextView tvScore;
	private TextView tvHighish ;
	private GameView gameView ;

	private static MainActivity mainActivity = null;

	public static MainActivity getMainActivity() {
		return mainActivity;
	}
	public MainActivity() {
		mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		preferences = getSharedPreferences("Brioal", MODE_WORLD_READABLE);
		editor = preferences.edit();
		editor.putString("Desc", "游戏2048 ，界面完成，图标未完成");
		editor.apply();
		tvScore = (TextView) findViewById(R.id.tvScore);
		tvHighish = (TextView) findViewById(R.id.tvHighist);
		tvHighish.setText(preferences.getInt("Hight", 0) + "");
		gameView = (GameView) findViewById(R.id.gameView);
	}

	public void saveScore() {
		editor.clear();
		editor.putInt("Hight", Integer.valueOf(tvHighish.getText().toString()));
		editor.apply();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void clearScore(){
		score = 0;
		showScore();
	}
	
	public void showScore(){
		tvScore.setText(score+"");
		if (score > Integer.valueOf(tvHighish.getText().toString())) {
			tvHighish.setText(score+"");
		}
		saveScore();
	}
	
	public void addScore(int s){
		score+=s;
		showScore();
	}

	public void onRestart(View view) {
		gameView.startGame();
	}


}
